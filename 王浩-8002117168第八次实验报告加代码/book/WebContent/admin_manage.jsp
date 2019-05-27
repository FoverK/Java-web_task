<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员界面</title>
<style>
	a{
		color:blue;
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
	<div class = "book_manage">
	<h3>对图书的管理</h3>
	<p><a href = "selectBook.jsp">查询图书</a></p>
	<p><a href = "deleteBook.jsp">删除图书</a></p>
	<p><a href = "updateSelectBook.jsp">修改图书</a></p>
	<p><a href = "insertBook.jsp">插入图书</a></p>
	<p><a href = "showAllBook">查看所有图书</a></p>
	
	</div>
	
	<div class = "user_manage">
	<h3>对用户的管理</h3>
	<p><a href = "deleteUser.jsp">删除用户</a></p>
	</div>
</body>
</html>