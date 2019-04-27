<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新界面</title>
</head>
<body>
<h3>更新学生信息页面</h3>
	<form method="post" action="UpDateServlet">
	<input type="hidden" name="sid" value="${stu.sid }">
	<table border="1" width="1000">
		<tr align="center">
			<td>姓名：　</td>
			<td><input type="text" name="name" value="${stu.sname }"></td>
		</tr>
		<tr align="center">
			<td>性别：　</td>
			<td><input type="radio" name="gender" value="男" <c:if test="${stu.gender == '男' }">checked</c:if>>男
				<input type="radio" name="gender" value="女" <c:if test="${stu.gender == '女' }">checked</c:if>>女
			</td>
		</tr>
		<tr align="center">
			<td>电话：　</td>
			<td><input type="text" name="phone" value="${stu.phone }"></td>
		</tr>	
		<tr align="center">
			<td>生日：　</td>
			<td><input type="text" name="birthday" value="${stu.birthday }"></td>
		</tr>
		<tr align="center">
			<td>爱好：　</td>
			<td>
				<input type="checkbox" name="hobby" value="唱" <c:if test="${fn:contains(stu.hobby,'唱')}">checked</c:if>>唱歌
				<input type="checkbox" name="hobby" value="跳" <c:if test="${fn:contains(stu.hobby,'跳')}">checked</c:if>>跳
				<input type="checkbox" name="hobby" value="rap" <c:if test="${fn:contains(stu.hobby,'rap')}">checked</c:if>>rap
				<input type="checkbox" name="hobby" value="篮球" <c:if test="${fn:contains(stu.hobby,'篮球')}">checked</c:if>>篮球
				<input type="checkbox" name="hobby" value="足球" <c:if test="${fn:contains(stu.hobby,'足球')}">checked</c:if>>足球
				<input type="checkbox" name="hobby" value="看书" <c:if test="${fn:contains(stu.hobby,'看书')}">checked</c:if>>看书
			</td>
		</tr>
		<tr align="center">
			<td>简介：　</td>
			<td><textarea name="info" cols="20" rows="3">${stu.info }</textarea></td>
		</tr>	
		<tr align="center">
			<td colspan="2"><input type="submit" value="添加"></td>
		</tr>
	</table>
	</form>
</body>
</html>