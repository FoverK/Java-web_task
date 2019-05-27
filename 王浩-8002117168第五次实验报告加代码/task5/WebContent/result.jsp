<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  半径：${param.radius}
  <jsp:useBean id="c" class="com.liqiang.bean.CircleBean"/>
  <jsp:setProperty name="c" property="radius" value="${param.radius}"/>
  半径为：<jsp:getProperty name="c" property="radius"/>的圆的面积:<jsp:getProperty name="c" property="area"/>
</body>
</html>