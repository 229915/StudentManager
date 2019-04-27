package priv.xjh.servlet;

import java.io.IOException;
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
 * 用于处理学生的添加请求
 * @author xjh
 *
 */
public class AddServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {

			//１．获取客户端提交上来的数据
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
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			
			Student student = new Student(name, gender, phone, date,hobby,info);
			
			StudentService service = new StudentServiceImpl();
			service.insert(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//３．跳转到列表页
		request.getRequestDispatcher("StudentListServlet").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
