<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="output.jsp" method="post">
      <table>
         <tr>
           <td>姓名</td><td><input type="text" name="name"/></td>
         </tr>
         
         <tr>
           <td>性别</td><td><input type="text" name="sex"/></td>
         </tr>
         
         <tr>
           <td>出生年月</td><td><input type="text" name="birth"/></td>
         </tr>
         
         <tr>
           <td>民族</td><td><input type="text" name="nation"/></td>
         </tr>
         
          <tr>
           <td>个人介绍</td><td><input type="text" name="intro"/></td>
         </tr>
          <tr>
           <td><input type="submit" value="提交"/></td>
         </tr>
      </table>
   </form>
</body>
</html>