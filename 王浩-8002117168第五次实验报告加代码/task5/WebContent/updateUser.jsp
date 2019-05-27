<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


		<c:if test="${user == null}">
			     <form action="UserServlet?method=5" method="post">
				       <input type="text" name="userid" placeholder="请输入需要修改的ID"/>    <input type="submit" value="提交 "/>       
			     </form>
	    </c:if>
		 
		 
		 <c:if test="${user != null}">
		      <form action="UserServlet?method=4" method="post">
		        <table>
			        <tr>
	              		  <td>用户ID</td><td><input type="text" value="${user.userid}" /></td>   
			        </tr>
			        <tr>
			              <td>用户姓名</td><td><input type="text" value="${user.username}"/></td>   
			        </tr>
			        <tr>
			              <td>用户性别</td><td><input type="text" value="${user.sex}"/></td>   
			        </tr>
		        </table>
     		</form>
		 </c:if>
     

</body>
</html>