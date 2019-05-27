<%@ page language="java" contentType="text/html; charset=UTF-8" import = "javabean.*,java.util.*,DAO.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户所选图书信息</title>
</head>
	<h3>用户<%=(String)session.getAttribute("username") %>当前借书的信息:</h3>
		<ul>
		<c:forEach items = "${b_list}" var = "b">
			<li>${b.bname }</li>
		</c:forEach>
		</ul>
	<div>共计图书：${b.bnum}</div>
</body>
</html>