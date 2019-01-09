<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>申通后台登录</title>
<link rel="shortcut icon" href="imgs/STO.jpg"/>
<!-- Custom Theme files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="后台登录" />
<script type="text/javascript" src="layui/jquery.min.js"></script>
<script type="text/javascript" src="layui/myCookie.js"></script>
</head>
<body>
	<!--header start here-->
	<div class="login-form">
		<img src="images/sto_logo.png" alt=""
			style="margin-left: 580px; margin-bottom: 50px;" />
		<div class="login-top">
			<form action="stoLogin.action" method="post">
				<h2 id="erro" style="text-align: center; margin-bottom: 10px; color: red; display: none;">账号或密码错误！</h2>
				<div class="login-ic">
					<i></i> <input type="text" id="account" placeholder="员工账户" />
					<div class="clear"></div>
				</div>
				<div class="login-ic">
					<i class="icon"></i> <input type="password" id="pass"
						placeholder="密码" />
					<div class="clear"></div>
				</div>
			</form>
			<div class="log-bwn">
				<input id="go" type="submit" value="Login">
			</div>
		</div>
		<p class="copy">© 2017.All RIGHT RESERVED.申通快递有限公司 版权所有</p>
	</div>
	<script type="text/javascript">
		$("#go").click(function(){
			$.ajax({
				url:'stoLogin.action',
				type:'post',
				data:'account='+$("#account").val()+'&pass='+$("#pass").val(),
				success:function(msg){
					if(msg.length==1){
						setCookie(msg[0].empNo,msg[0].empImg,10000000);
						window.location.href="selectMenuId.action?empNo="+msg[0].empNo+"&empName="+msg[0].empName;
					}else{
						$("#erro").slideDown("slow");
					}
				}
			});
		})
	</script>
</body>
</html>