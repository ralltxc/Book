<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link rel="stylesheet" type="text/css" href="css1/style.css" />
<link rel="stylesheet" type="text/css" href="css1/body.css"/> 
</head>
<body>
<div class="container">
	<section id="content">
		<form action="login.user" method="post">
			<h1>管理员登录</h1>
			<div>
				<input type="text" placeholder="用户名" required="" id="username" name="username"/>
			</div>
			<div>
				<input type="password" placeholder="密码" required="" id="password" name="password"/>
			</div>
			 <div class=""> 
				<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>			</div> 
			<div>
				<!-- <input type="submit" value="Log in" /> -->
				<input type="submit" value="登录" class="btn btn-primary" id="js-btn-login"/>
			</div>
		</form><!-- form -->
	</section><!-- content -->
</div>
<!-- container -->


<br><br><br><br>
</body>
</html>