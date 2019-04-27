package priv.xjh.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.xjh.domain.Student;
import priv.xjh.service.StudentService;
import priv.xjh.service.impl.StudentServiceImpl;
/*
 * 
 * 负责查询所有的学生信息，然后呈现到Ｌｉｓｔ。ｊｓｐ页面上
 * 
 */
public class StudentListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			try {
				StudentService service = new StudentServiceImpl();
				List<Student> list = service.findAll();
				
				request.setAttribute("list", list);
				
				request.getRequestDispatcher("list.jsp").forward(request,response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
