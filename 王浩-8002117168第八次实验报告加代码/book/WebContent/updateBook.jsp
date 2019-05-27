<%@ page language="java" import = "javabean.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
</head>
<body>
	<form action="updateBook" method = "post">
		图书名:<input type = "text" name = "bname" value = "${book.bname}" /><br><br>
		图书号:<input type = "text" name = "bid" value = "${book.bid}"/><br><br>
		作    者:<input type = "text" name = "author" value = "${book.author}"/><br><br>
		价    格:<input type = "text" name = "price" value = "${book.price}"/><br><br>
		备注字段:<input type = "text" name = "addition" value = "${book.addition}"/><br><br>
		<input type = "submit" value = "修改">
	</form>
</body>
</html>