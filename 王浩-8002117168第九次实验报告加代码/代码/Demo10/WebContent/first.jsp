<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>输入界面</title>
</head>
<body>
	<form action="second.jsp" method="post">
	用户名：<input type="text" value="${param.username }" name="username">
	<br><br>
	密码：<input type="password"  name="pwd">
	<br><br>
	<input type="submit" value="提交" >
	<input type="reset" value="重输">
	</form>
	<br><br>
	<div>
	<c:if test="${!empty error }">
	<c:out value="${error }"></c:out>
	</c:if>
	</div>
</body>
</html>