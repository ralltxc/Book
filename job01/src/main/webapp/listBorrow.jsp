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
		<form action="list" method="get">
			<h1>借阅信息查询</h1>
			<div>
				<input type="text" placeholder="请输入读者编号" id="username" name="readerid"/>
			</div>
			 <div class="">
				<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>			</div> 
			<div>
				<input type="submit" value="查询" class="btn btn-primary" id="js-btn-login"/>
			</div>
		</form>
	</section>
</div>



<br><br><br><br>
</body>
</html>