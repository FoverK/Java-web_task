<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'outputData.jsp' starting page</title>
    
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
   姓名：<%=(String)request.getAttribute("name") %><br><br>
   年龄：<%=(String)request.getAttribute("age") %><br><br>
   出生日期：<%=(String)request.getAttribute("birthday") %><br><br>
   民族：<%=(String)request.getAttribute("nation") %><br><br>
   个人介绍：<%=(String)request.getAttribute("introduction") %>
  </body>
</html>
