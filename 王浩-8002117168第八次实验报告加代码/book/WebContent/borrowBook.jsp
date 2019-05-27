<%@ page language="java" contentType="text/html; charset=UTF-8" import = "DAO.*,java.util.*,javabean.*"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>借书</title>
<style type="text/css">
	p{
		width:150px;
	}
</style>
</head>
<body>
	<% 
		request.setCharacterEncoding("utf-8");
		LibraryDAO ld = new LibraryDAO();
		List<Book> lb = new ArrayList<Book>();
		try {
			lb = ld.selectAllBook();
			request.setAttribute("booklist", lb);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	%>
	<h4>图书馆所有的书如下</h4>
	<form action="borrowBook" method = "post">
		<c:forEach items = "${booklist}" var = "book">
		${book.bname }<input type = "checkbox" name = "book" value = "${book.bname}">
		</c:forEach>
		<input type = "submit" value = "借走">
	</form>
</body>
</html>