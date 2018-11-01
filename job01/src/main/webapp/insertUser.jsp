<%
	Object obj = session.getAttribute("user");
if(obj==null){
	response.sendRedirect("login.jsp");
	return ;
}
%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="topheader">
					<h1 id="title">
						<a href="#">main</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<form action="insert.user" method="post">
				<table class="table">

					<tr class="row2">
						<td>用户名</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr class="row1">
						<td>密码</td>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<input type="submit" class="button" value="提交">
			</form>
			<div id="footer">
				<div id="footer_bg">ABC@126.com</div>
			</div>
		</div>
	</div>
</body>
</html>