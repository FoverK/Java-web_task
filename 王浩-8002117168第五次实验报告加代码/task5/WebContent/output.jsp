<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <jsp:useBean id="user" class="com.liqiang.bean.UserBean"/>
   <jsp:setProperty name="user" property="name" value="${param.name}"/>
   <jsp:setProperty name="user" property="sex"  value="${param.sex}"/>
   <jsp:setProperty name="user" property="birth" value="${param.birth}"/>
   <jsp:setProperty name="user" property="nation" value="${param.nation}"/>
   <jsp:setProperty name="user" property="intro" value="${param.intro}"/>
   
   <jsp:getProperty name="user" property="name"/>
</body>
</html>