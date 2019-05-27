<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>按条件查询</title>
    
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
  	请选择查询条件：<br>
    <form method = "post" action = "find">
        <select name = "select">
        	<option value = "name">name</option>
        	<option value = "sex">sex</option>
        	<option value = "age">age</option>
        	<option value = "address">address</option>
        	<option value = "telesphone">telephone</option>
        </select>
    	<input type = "text" name = "item"><br><br>
    	<input type = "submit" value = "查询">
    </form>
  </body>
</html>
