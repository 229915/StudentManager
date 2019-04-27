package priv.xjh.service;

import java.sql.SQLException;
import java.util.List;

import priv.xjh.domain.PageBean;
import priv.xjh.domain.Student;
/**
 * 这是学生的业务处理规范
 * @author xjh
 *
 */
public interface StudentService {
	/**
	 * 
	 * 获取的学生数据
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	PageBean findStudentByPage(int currentPage) throws SQLException;
	/**
	 * 查询所有学生
	 * @return List<Student>
	 * @throws SQLException 
	 */
	List<Student> findAll() throws SQLException;
	
	/**
	 * 定义模糊查询的方法,根据姓名，性别，或者两者都有进行查询
	 * @param sname
	 * @param sgender
	 * @return
	 * @throws SQLException
	 */
	List<Student> searchStudent(String sname,String sgender) throws SQLException;
	
	/**
	 * 
	 * 根据ｉｄ查询单个学生的信息
	 * @param sid
	 * @return
	 * @throws SQLException
	 */
	Student findStudentById(int sid) throws SQLException;
	/**
	 *添加学生到数据库中 
	 *
	 */
	void insert(Student student) throws SQLException;
	
	/**
	 * 删除表中的学生信息
	 */
	void delete(int sid) throws SQLException;
	
	/**
	 * 更新学生信息
	 * @param student
	 * @throws SQLException
	 */
	void update(Student student) throws SQLException;
}
