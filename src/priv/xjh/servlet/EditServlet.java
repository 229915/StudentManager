package priv.xjh.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.xjh.domain.Student;
import priv.xjh.service.StudentService;
import priv.xjh.service.impl.StudentServiceImpl;
/**
 * 
 * 处理单个学生的更新，查询一个学生的信息，然后跳转到更新页面
 * @author xjh
 *
 */
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//j.接受ｉｄ
			int sid = Integer.parseInt(request.getParameter("sid"));
			
			//2.查询学生数据
			StudentService service = new StudentServiceImpl();
			Student stu = service.findStudentById(sid);
			
			//3.存数据
			request.setAttribute("stu", stu);
			
			//4.跳转到页面
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
