<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
		form{
				display:block;
				width:300px;
				margin-left:550px;
				text-align:center;
				background-color:skyblue;
		}
</style>
</head>
<body>
<div>
		<form  method = "post" name = "form_name">
				<h3>学生登录</h3>
				 学生姓名：<input type = "text" name = "name" ><br><br>
				学生密码：<input type = "password" name = "password" ><br><br>
				<input type = "submit" value = "登录"  onclick=" form_name.action ='stuLogin' ">
				<input type = "submit"  value = "注册" onclick=" form_name.action ='register.jsp' ">
		</form>
</div>	
</body>
</html>