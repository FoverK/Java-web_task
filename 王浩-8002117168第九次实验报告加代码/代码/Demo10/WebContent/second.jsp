<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>检测界面</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");		
	%>
	<c:choose>
	<c:when test="${param.username == 'abc' && param.pwd=='123'}">
	<jsp:forward page="third.jsp"></jsp:forward>
	</c:when>
	<c:otherwise>
	<%request.setAttribute("error", "账号密码错误！请重新输入。") ;%>
	<jsp:forward page="first.jsp"></jsp:forward> 
	</c:otherwise>
	</c:choose>
	
</body>
</html>