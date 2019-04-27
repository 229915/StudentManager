package priv.xjh.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.xjh.service.StudentService;
import priv.xjh.service.impl.StudentServiceImpl;

/**
 * 
 * 用于处理删除学生
 * @author xjh
 *
 */
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1.获取数据
			int sid = Integer.parseInt(request.getParameter("sid"));
			//2.调取ｓｅｒｖｉｃｅ层
			StudentService service = new StudentServiceImpl();
			service.delete(sid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//３．跳转到列表页
		request.getRequestDispatcher("StudentListServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
