<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生页面</title>
</head>
<body>
	<h3>添加学生页面</h3>
	
	<form method="post" action="AddServlet">
	<table border="1" width="1000">
		<tr align="center">
			<td>姓名：　</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr align="center">
			<td>性别：　</td>
			<td><input type="radio" name="gender" value="男">男
				<input type="radio" name="gender" value="女">女
			</td>
		</tr>
		<tr align="center">
			<td>电话：　</td>
			<td><input type="text" name="phone"></td>
		</tr>	
		<tr align="center">
			<td>生日：　</td>
			<td><input type="text" name="birthday"></td>
		</tr>
		<tr align="center">
			<td>爱好：　</td>
			<td><input type="checkbox" name="hobby" value="唱">唱
			<input type="checkbox" name="hobby" value="跳">跳
			<input type="checkbox" name="hobby" value="rap">rap
			<input type="checkbox" name="hobby" value="篮球">篮球
			<input type="checkbox" name="hobby" value="足球">足球
			<input type="checkbox" name="hobby" value="看书">看书</td>
		</tr>
		<tr align="center">
			<td>简介：　</td>
			<td><textarea name="info" cols="20" rows="3"></textarea></td>
		</tr>	
		<tr align="center">
			<td colspan="2"><input type="submit" value="添加"></td>
		</tr>
	</table>
	</form>
</body>
</html>