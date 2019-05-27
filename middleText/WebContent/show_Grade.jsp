<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel= "stylesheet " href = "show_Grade.css" />
</head>
<body>
	<div class = "info">
	<p>${quesNum}道题</p>
	<p>学生<font color = "green" size = "12px">${name}</font>答题情况</p>
	<p>做对${sure}道题，做错${error}道题</p>
	<p>成绩：<font color = "red" size = "15px">${grade}</font></p>
	<p>答案:</p>
	</div>
	<div class = "question">
	<table border = "1px">
			<tr>
					<td>问题</td>
			</tr>
			<c:forEach items = "${question}" var = "item">		
			<tr>
					<td>${item}</td>
			</tr>	
			</c:forEach>		
			</table>
	</div>
	<div class = "answer">
	
			<table border = "1px">
			<tr>
					<td>结果</td>
			</tr>
			<c:forEach items = "${answer}" var = "item">
			<tr>
								<td>${item}</td>
			</tr>
			</c:forEach>
			</table>
	</div>
	<div class = "order">
			<table border = "1px">
			<tr>
					<td>排名</td>
			</tr>
			<c:forEach items = "${sg_list}" var = "item">
			<tr>
								<td>${item.name}</td>
								<td>${item.grade}</td>
			</tr>
			</c:forEach>
			</table>
	</div>
</body>
</html>