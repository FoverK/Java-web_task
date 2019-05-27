<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>操作界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="main.css" />

         
  </head>

  
  <body>
  <center>
    <div>
    
    	<ul>
    	<li>名片管理</li>
    	<li><a href = "findAllCard">浏览名片信息</a></li>

    	<li><a href = "insertCard.jsp" >插入名片信息</a></li>

    	<li><a href = "findCard.jsp">查询名片信息</a></li>

    	<li><a href = "update_findCard.jsp">修改名片信息</a></li>

    	<li><a href = "deleteCard.jsp">删除名片信息</a></li>
    	
    	</ul>
    </div>	
    <div>
    	<ul>
    		<li>回收站</li>
    		<li><a href = "findAllTrash">浏览回收站信息</a></li>
    	
    		<li><a href = "returnToTrash">将名片还原</a></li>
    	
    		<li><a href = "deleteAllTrash">清空回收站</a></li>
    	
    		<li><a href = "findTrash.jsp">查询回收站信息</a></li>
    	</ul>
    </div>
    </center>
  </body>
</html>
