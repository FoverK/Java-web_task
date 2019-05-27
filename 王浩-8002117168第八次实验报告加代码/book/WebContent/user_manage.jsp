<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户界面</title>
<style>
	a{
		color:black;
		text-decoration:none;
	}
	a:visited{
		color:black;
	}
	a:hover{
		color:red;
	}
</style>
</head>
<body>
	<div class = "book">
	<p><a href = "showSelectedBook">查看该用户所借的图书</a></p>
	<p><a href = "borrowBook.jsp">借书</a></p>
	<p><a href = "returnBook.jsp">还书</a></p>
	</div>
	<div>注意：每人只能借8本书！</div>
</body>
</html>