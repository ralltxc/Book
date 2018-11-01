<%
	Object obj = session.getAttribute("user");
if(obj==null){
	response.sendRedirect("login.jsp");
	return ;
}
%>

<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
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
			<form action="update.user" method="post">
				<table class="table">
					<tr class="row1">
						<td>ID</td>
						<td><input type="text" name="id"
							value="<%=request.getParameter("id")%>" readonly="readonly"></td>
					</tr>
					<tr class="row2">
						<td>用户名</td>
						<td><input type="text" name="username"
							value="<%=request.getParameter("username")%>" readonly="readonly"></td>
					</tr>
					<tr class="row1">
						<td>密码</td>
						<td><input type="text" name="password"
							value="<%=request.getParameter("password")%>"></td>
					</tr>
				</table>
				<input type="submit" class="button" value="确认">
			</form>
			<div id="footer">
				<div id="footer_bg">ABC@126.com</div>
			</div>
		</div>
	</div>
</body>
</html>