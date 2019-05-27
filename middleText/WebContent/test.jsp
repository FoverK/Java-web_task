<%@ page language="java" import = "test.GeneratePaper" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>
<body>
	<h1 align = "center">小学生期中考试题</h1>
	<form action="deal" method = "post">
			<table border = "1px" align = "center">
					<tr>
								<td>问题</td>
								<td>结果</td>
					</tr>
					<c:forEach items = "${question}" var = "item">
							<tr>
								<td>${item}</td>
								<td>
								<input type = "text"  name = "result" required>
								</td>
						</tr>	
					</c:forEach>		
			</table>
			<input type = "submit" value = "提交" onclick = "checkNum()">
	</form>
		
</body>
</html>