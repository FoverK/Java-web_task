<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录界面</title>
    
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

    <form name = "form" method = "post">
    	用户名：<input type = "text" name = "name" required  /><br><br>
    	密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type = "text" name = "password" required /><br><br>
    	<input type = "submit" value = "登录" onclick = "form.action='login'" >&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type = "submit" value = "注册" onclick = "form.action='register'" />
    </form>
  </center>
  </body>
</html>
