package priv.xjh.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.xjh.domain.PageBean;
import priv.xjh.service.StudentService;
import priv.xjh.service.impl.StudentServiceImpl;

/**
 * 
 * 这是用于分页显示学生信息的Ｓｅｒｖｌｅｔ
 * @author xjh
 *
 */
public class StudentListPageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1.获取页码数
			int currentpage = Integer.parseInt(request.getParameter("currentPage"));
			
			//2.根据指定的页数，从该页找到数据回来
			StudentService service = new StudentServiceImpl();
			PageBean pageBean = service.findStudentByPage(currentpage);
			
			request.setAttribute("pageBean", pageBean);
			//3,跳转页面		
			request.getRequestDispatcher("list_page.jsp").forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
