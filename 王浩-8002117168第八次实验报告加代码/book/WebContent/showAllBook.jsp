<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>浏览所有图书</title>
</head>
<body>
	<h3 align = "center">所有图书如下:</h3>
	<table border = "1px" align = "center">
		<tr>
			<td>图书号</td>
			<td>图书名</td>
			<td>作者</td>
			<td>价格</td>
			<td>备注字段</td>
		</tr>
		<c:forEach items = "${booklist }" var = "book">
		<tr>
			<td>${book.bid }</td>
			<td>${book.bname }</td>
			<td>${book.author }</td>
			<td>${book.price }</td>
			<td>${book.addition }</td>
		</tr>	
		</c:forEach>
	</table>
</body>
</html>