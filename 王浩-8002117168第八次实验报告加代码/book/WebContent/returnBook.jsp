<%@ page language="java" contentType="text/html; charset=UTF-8" import = "javabean.*,java.util.*,DAO.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>还书</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		List<BorrowBook> b_list = new ArrayList<BorrowBook>();
		BorrowInfoDAO bi = new BorrowInfoDAO();
		b_list = bi.getInfo((String)session.getAttribute("username"));
		request.setAttribute("b_list", b_list);	
	%>
	<h3>用户<%=(String)session.getAttribute("username") %>借书 的信息:</h3>
	<form action="returnBook" method = "post">
		<c:forEach items = "${b_list}" var = "b">
			${b.bname }<input type = "checkbox" name = "book" value = "${b.bname}"><br><br>
		</c:forEach>
		<input type = "submit" value = "还书">
	</form>
</body>
</html>