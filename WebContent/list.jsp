<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表页面</title>

<script type="text/javascript">
	function doDelete(sid){
		/*
			如果这里弹出的是对话框，用户点击的是确认，就马上去请求Ｓｅｒｖｌｅｔ
			如何知道用户点击的是确认
			如何在ｊｓ的方法中请求ｓｅｒｖｌｅｔ。
		*/
		
		var flag = confirm("是否确定删除?");
		
		if(flag){
			//表明点了确定，访问ｓｅｒｖｌｅｔ.在当前标签上打开超链接

			window.location.href="DeleteServlet?sid="+sid;
		}
	}
</script>
</head>
<body>
	<form method="post" action="SearchStudentServlet">
	<table border="1" width="1000">
		<tr>
			<td colspan="8">
				<span>按姓名查询: </span><input type="text" name="sname"/>
				<span>按性别查询</span>
				<select name="sgender">
					<option value="">--请选择--
					<option value="男">男
					<option value="女">女
				</select>
				<input type="submit" value="查询">

				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="add.jsp">添加</a>
			</td>
		</tr>
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>电话</td>
			<td>生日</td>
			<td>爱好</td>
			<td>简介</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list }" var="stu">
			<tr align="center">
			<td>${ stu.sid}</td>
			<td>${ stu.sname}</td>
			<td>${ stu.gender}</td>
			<td>${ stu.phone}</td>
			<td>${ stu.birthday}</td>
			<td>${ stu.hobby}</td>
			<td>${ stu.info}</td>
			<td><a href="EditServlet?sid=${stu.sid }">更新</a>  <a href="#" onclick="doDelete(${stu.sid})">删除</a></td>
		</tr>
		
		</c:forEach>
	</table>
	</form>
</body>
</html>