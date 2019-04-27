package priv.xjh.service.impl;

import java.sql.SQLException;
import java.util.List;

import priv.xjh.dao.StudentDao;
import priv.xjh.dao.impl.StudentDaoImpl;
import priv.xjh.domain.PageBean;
import priv.xjh.domain.Student;
import priv.xjh.service.StudentService;

public class StudentServiceImpl implements StudentService {

	public List<Student> findAll() throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		
		return dao.findAll();
	}

	public void insert(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.insert(student);
	}

	public void delete(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.delete(sid);
		
	}

	public Student findStudentById(int sid) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		
		return dao.findStudentById(sid);
	}

	public void update(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		
		dao.update(student);
		
	}

	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.searchStudent(sname, sgender);
	}

	public PageBean findStudentByPage(int currentPage) throws SQLException {
		//封装分页的该页数据
		
		int Page_Size = StudentDao.Page_Size;
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setCurrentPage(currentPage);//设置当前页数
		pageBean.setPageSize(Page_Size);//设置每一面显示多少条记录
		
		StudentDao dao = new StudentDaoImpl();
		
		//总的记录数
		int count = dao.findCount();
		pageBean.setTotalSize(count);
		
		List<Student> list = dao.findStudentByPage(currentPage);
		pageBean.setList(list);//设置这一页的学生数据
		
		pageBean.setTotalPage(count % Page_Size == 0 ?(count/Page_Size):(count/Page_Size+1));//设置总的页数
		return pageBean;
	}

}
