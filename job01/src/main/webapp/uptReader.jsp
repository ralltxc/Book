<%
	Object obj = session.getAttribute("user");
if(obj==null){
	response.sendRedirect("login.jsp");
	return ;
}
%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.* ,java.text.SimpleDateFormat " %>
<html>
<head>
<title>add Reader</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />

</head>

<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
						2018-09-28
					</p>
				</div>
				<div id="topheader">
					<h1 id="title">
						<a href="#">Main</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>修改读者信息:</h1>
				<form action="update.reader" method="post">
					<table cellpadding="0" cellspacing="0" border="0"
						class="form_table">
						<tr>
							<td valign="middle" align="right">读者编号:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="readerid"  value="<%=request.getParameter("readerid")%>"></td>
						</tr>
						<tr>
							<td valign="middle" align="right">读者类别:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="type"  value="<%=request.getParameter("type")%>"></td>
						</tr>
						<tr>
							<td valign="middle" align="right">姓名:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="name"  value="<%=request.getParameter("name")%>"></td>
						</tr>
						<tr>
							<td valign="middle" align="right">年龄:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="age"  value="<%=request.getParameter("age")%>"></td>
						</tr>
						<tr>
							<td valign="middle" align="right">性别:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="sex"  value="<%=request.getParameter("sex")%>"></td>
						</tr>
						<tr>
							<td valign="middle" align="right">电话:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="phone"  value="<%=request.getParameter("phone")%>"></td>
						</tr>
						<tr>
							<td valign="middle" align="right">所在部门:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="dept"  value="<%=request.getParameter("dept")%>"></td>
						</tr>
						<tr>
							<td valign="middle" align="right">注册日期:</td>
							<td valign="middle" align="left"><input type="text"
								class="inputgri" name="regdate"  value="<%=request.getParameter("regdate")%>"></td>
						</tr>
					</table>
					<p>
						<input type="submit" class="button" value="确定" />
					</p>
				</form>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">ABC@126.com</div>
		</div>
	</div>
</body>
</html>
