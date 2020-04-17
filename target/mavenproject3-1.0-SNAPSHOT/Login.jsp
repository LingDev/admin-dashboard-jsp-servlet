<%-- 
    Document   : Login
    Created on : Apr 15, 2020, 1:30:55 AM
    Author     : vando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Creative Account Form Responsive Widget Template | Home :: w3layouts</title>
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<link href="asset/css/login.css" rel="stylesheet" type="text/css" media="all"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Creative Account Form Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--google fonts-->
<link href='//fonts.googleapis.com/css?family=Poppins:400,600,500,700' rel='stylesheet' type='text/css'>
<script>$(document).ready(function(c) {
	$('.log-close').on('click', function(c){
		$('.login').fadeOut('slow', function(c){
	  		$('.login').remove();
		});
	});	  
});
</script>
</head>
<body>
	<h1>Login</h1>
	<div class="login">
		<h2><span>Secure Login</span> <i>or get a</i> <a href="#">free account</a></h2>
		<span class="log-close"> </span>
		<div class="login-bottom">
		<form method="POST" action="LoginServlet">
		<div class="text">
			<input type="text" name="userName" placeholder="User" required=""/>
			<span class="men"></span>
			<div class="clear"> </div>
		</div>
		<div class="text">		
			<input type="password" name="password" placeholder="Password..." required=""/>
			<span class="pass"></span>
			<div class="clear"> </div>
		</div>	
		
        <div class="remember">
			<div class="remember-top">
			<a href="#">Forgot Password</a>
			<span class="checkbox1">
				 <label class="checkbox"><input type="checkbox" name="" checked=""><i> </i>Remember me</label>
			</span>
			</div>
			<div class="send">
				<input type="submit" value="Sign In">
			</div>
		<div class="clear"> </div>
		</div>
		</form>
	</div>
	</div>
	<div class="copy-right">
		<p>© 2020 Design by  <a href="https://www.facebook.com/Linh.Cute2511" target="_blank">  Linh Doan </a></p>
	</div>
</body>
</html>