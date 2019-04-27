package priv.xjh.domain;

import java.util.Date;

/**
 * 这是学生封装的对象ｂｅａｎ
 * @author xjh
 *
 */
public class Student {
	private int sid;
	private String sname;
	private String phone;
	private String hobby;
	private String info;
	private Date birthday;
	
	public Student() {
		super();
	}
	
	public Student(int sid ,String sname, String gender, String phone, Date birthday,String hobby,String info) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.phone = phone;
		this.hobby = hobby;
		this.info = info;
		this.birthday = birthday;
		this.gender = gender;
	}
	public Student( String sname, String gender, String phone, Date birthday,String hobby,String info) {
		super();
		this.sname = sname;
		this.phone = phone;
		this.hobby = hobby;
		this.info = info;
		this.birthday = birthday;
		this.gender = gender;
	}
	private String gender;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
