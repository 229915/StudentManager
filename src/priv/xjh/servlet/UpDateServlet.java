package priv.xjh.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.xjh.domain.Student;
import priv.xjh.service.StudentService;
import priv.xjh.service.impl.StudentServiceImpl;

/**
 * 
 * 将数据存储到数据库中
 * @author xjh
 *
 */
public class UpDateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			//１．获取客户端提交上来的数据
			int sid = Integer.parseInt(request.getParameter("sid"));

			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday");
			//String hobby = request.getParameter("hobby");
			
			String[] hobbies = request.getParameterValues("hobby");
			String info = request.getParameter("info");
			
			
			String hobby = Arrays.toString(hobbies);
			hobby = hobby.substring(1,hobby.length()-1);
			//2.添加到数据库
			Date date;
			date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			
			Student student = new Student(sid,name, gender, phone, date,hobby,info);
			
			//３．更新数据库信息
			StudentService service = new StudentServiceImpl();
			service.update(student);
			
			//４．跳转到查询页面
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
