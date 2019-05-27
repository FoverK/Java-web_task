<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <form action="UserServlet?method=1" method="post">
        <table>
	        <tr>
	              <td>用户ID</td><td><input type="text" name="userid"/></td>   
	        </tr>
	        <tr>
	              <td>用户姓名</td><td><input type="text" name="username"/></td>   
	        </tr>
	        <tr>
	              <td>用户性别</td><td><input type="text" name="sex"/></td>   
	        </tr>
	        <tr>
	              <td><input type="submit" value="提交"/></td>   
	        </tr>
        </table>
     </form>
</body>
</html>