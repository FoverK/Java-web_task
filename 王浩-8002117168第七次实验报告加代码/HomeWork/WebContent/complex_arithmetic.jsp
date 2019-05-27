<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method = "post" name = "form">
		请输入第一个虚数的实部：<input type = "text"  name = "rno1" /><br><br>
		请输入第一个虚数的虚部：<input type = "text"  name = "vno1" /><br><br>
		请选择运算符：<select   name = "oper">
							<option>+</option>
							<option>-</option>
							<option>*</option>
							<option>/</option>
					  </select><br><br>
		请输入第二个虚数的实部：<input type = "text" name = "rno2" /><br><br>
		请输入第二个虚数的虚部：<input type = "text" name = "vno2" /><br><br>
		<input  type = "submit" value = "JavaBean+JSP提交" onclick = "form.action = 'caculate.jsp '"/>
		<input  type = "submit" value = "JavaBean+JSP + servlet提交" onclick = "form.action = 'caculate '"/>
	</form>
</body>
</html>