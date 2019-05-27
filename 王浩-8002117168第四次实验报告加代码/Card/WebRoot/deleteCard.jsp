<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>删除界面</title>
    
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
    <form method = "post" name = "form">
    <select name = "select">
        	<option value = "name">name</option>
        	<option value = "sex">sex</option>
        	<option value = "age">age</option>
        	<option value = "address">address</option>
        	<option value = "telesphone">telephone</option>
        </select>
        <input type = "text" name = "item"><br><br>
    	<input type = "submit" value = "彻底删除" onclick = "form.action = 'delete'"   />
    	<input type = "submit" value = "删除至回收站" onclick = "form.action = 'deleteToTrash'" />
    </form>
  </body>
</html>
