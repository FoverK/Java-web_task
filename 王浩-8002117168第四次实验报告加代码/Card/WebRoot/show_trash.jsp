<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show_trash.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center>
  <c:choose >
 	<c:when test = "${empty alltrash }">
 		<h2>未查询到符合该条件的名片！或没有记录！</h2>
 	</c:when >
 	<c:otherwise>
  	<table border = "1">
    	<tr><td>姓名</td><td>性别</td><td>年龄</td><td>地址</td><td>手机</td></tr>
    	<c:forEach var = "trash" items = "${alltrash }">
    	<tr><td>${trash.name }</td><td>${trash.sex }</td><td>${trash.age }</td><td>${trash.addr }</td>
    	<td>${trash.tel }</td></tr>
    	</c:forEach>
    </table>
    </c:otherwise>
  </c:choose>
  </center>
  </body>
</html>
