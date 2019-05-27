<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>插入名片</title>
    
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
    <form action = "insert" method = "post">
    	姓名：<input type = "text" name  = "name"><br><br>
    	性别：<input type = "text" name = "sex"><br><br>
    	年龄：<input type = "text" name = "age"><br><br>
    	地址：<input type = "text" name = "addr"><br><br>
    	手机：<input type = "text" name = "tel"><br><br>
    	<input type = "submit" value = "插入名片">&nbsp;&nbsp;
    	<input type = "reset" value = "重置名片">
    </form>
  </body>
</html>
