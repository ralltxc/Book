<%
	Object obj = session.getAttribute("user");
if(obj==null){
	response.sendRedirect("login.jsp");
	return ;
}
%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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
			<form action="update.rt" method="post">
				<table class="table">
					<tr class="row1">
						<td>编号</td>
						<td><input type="text" name="rid"
							value="<%=request.getParameter("id")%>" readonly="readonly"></td>
					</tr>
					<tr class="row2">
						<td>名称</td>
						<td><input type="text" name="rname"
							value="<%=request.getParameter("typename")%>" ></td>
					</tr>
					<tr class="row1">
						<td>名称</td>
						<td><input type="text" name="rmax"
							value="<%=request.getParameter("max")%>" ></td>
					</tr>
					<tr class="row2">
						<td>名称</td>
						<td><input type="text" name="limit"
							value="<%=request.getParameter("limit")%>" ></td>
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