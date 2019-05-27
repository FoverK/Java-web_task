<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
    <form action = "register" method = "post">
    	姓名：<input type = "text" name = "name"><br><br>
    	年龄：<input type = "text" name = "age"><br><br>
    	出生：<input type = "text" name = "birthday"><br><br>
    	民族：<input type = "text" name = "nation"><br><br>
    	<p>个人介绍：</p>
    	<textArea name = "introduction" cols = "22"rows = "3"></textArea><br><br>
    	<input type = "submit" value = "注册">
    	
    </form>
  </body>
</html>
