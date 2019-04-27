package priv.xjh.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import priv.xjh.dao.StudentDao;
import priv.xjh.domain.Student;
import priv.xjh.util.JDBCUtil2;
import priv.xjh.util.TestUtil;
/**
 * 这是ＳｔｕｄｅｎｔＤａｏ的实现，针对前面定义的规范，做出具体的实现
 * @author xjh
 *
 */
public class StudentDaoImpl implements StudentDao{
	/**
	 * 查询所有学生
	 * @throws SQLException 
	 */
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		String sql = "select * from stu";
		
		//BeanListHandler:将结果封装到一个ＪａｖａＢｅａｎ
		List<Student> list = runner.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
	}

	public void insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		
		runner.update("insert into stu values(null,?,?,?,?,?,?)",
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo()
				);
	}

	public void delete(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		
		runner.update("delete from stu where sid=?",sid);
		
	}

	public Student findStudentById(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		
		return runner.query("select * from stu where sid=?", new BeanHandler<Student>(Student.class),sid);
		
	}

	public void update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());		
		
		runner.update("update stu set sname=?,gender=?,phone=?,birthday=?,hobby=?,info=? where sid=?",
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo(),
				student.getSid()
				);
	}

	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		List<String> list = new ArrayList<String>();
		String sql = "select * from stu where 1=1";
		
		if(!TestUtil.isEmpty(sname)){
			sql = sql+" and sname like ?";
			list.add("%"+sname+"%");
		}
		if(!TestUtil.isEmpty(sgender)){
			sql = sql + " and gender = ?";
			list.add(sgender);
		}
		return runner.query(sql,new BeanListHandler<Student>(Student.class),list.toArray());
	}

	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		//第一个问号表示一页查询几条数据，第二个问好表示跳过前面多少条数据
		return runner.query("select * from stu limit ? offset ?", new BeanListHandler<Student>(Student.class),Page_Size,(currentPage-1)*Page_Size);
		
	}

	public int findCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		
		//用于处理平均值，总的个数
		Long result = (Long)runner.query("select count(*) from stu", new ScalarHandler());
		return result.intValue();
	}

}
