<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>登录界面</title>

<link rel="stylesheet" type="text/css" href="./css/style.css">

<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript" src="./js/vector.js"></script>

</head>
<body>

<div id="container">
	<div id="output">
		<div class="containerT">
			<h1>用户登录</h1>
			<form class="form" id="entry_form" method = "post" name = "form1">
				<input type="text" placeholder="用户名" id="entry_name" name = "name">
				<input type="password" placeholder="密码" id="entry_password" name = "password">
				<input type="submit" id="entry_btn" onclick = "form1.action = 'checkWho'" value = "登录">
				<button type="button" id="register_btn" onclick = "jump()">注册</button>
				<div id="prompt" class="prompt"></div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
    $(function(){
        Victor("container", "output");
        $("#entry_name").focus();
        $(document).keydown(function(event){
            if(event.keyCode==13){
                $("#entry_btn").click();
            }
        });
    });
    function jump(){
    	 window.location.href="register.jsp";
    	}
</script>
</body>
</html>