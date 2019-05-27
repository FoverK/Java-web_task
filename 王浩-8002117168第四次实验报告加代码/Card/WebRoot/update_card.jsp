<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改界面</title>
    
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
    <h1>请修改<font color = "red"><%=(String)request.getAttribute("name") %></font>名片的信息>></h1>
    <form action="update" method = "post">
    	姓名：<input type = "text" name  = "name" value = <%=(String)request.getAttribute("name") %>><br><br>
    	性别：<input type = "text" name = "sex" value = <%=(String)request.getAttribute("sex") %>><br><br>
    	年龄：<input type = "text" name = "age" value = <%=request.getAttribute("age") %>><br><br>
    	地址：<input type = "text" name = "addr" value = <%=(String)request.getAttribute("addr") %>><br><br>
    	手机：<input type = "text" name = "tel" value = <%=(String)request.getAttribute("tel") %>><br><br>
    	<input type = "submit" value = "修改">&nbsp;&nbsp;
    </form>
  </body>
</html>
