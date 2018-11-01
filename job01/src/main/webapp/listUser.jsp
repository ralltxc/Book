<%
	Object obj = session.getAttribute("user");
if(obj==null){
	response.sendRedirect("login.jsp");
	return ;
}
%>

<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.*,entity.*,java.text.*" %>
<html>
<head>
	<title>listUsers</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							<%
								Date date=new Date();
								SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
								out.write(sdf.format(date));
							%>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						用户列表
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								用户名
							</td>
							<td>
								密码
							</td>
							<td>
								操作
							</td>
						</tr>
						<%
							List<Users> users=(List<Users>)request.getAttribute("users");
						if(users!=null){
						for(int i=0;i<users.size();i++){
								Users u = users.get(i);
								%>
								<tr class="row<%=i%2+1%>">
									<td>
										<%=u.getId() %>
									</td>
									<td>
										<%=u.getName() %>
									</td>
									<td>
										<%=u.getPassword() %>
									</td>
									<td>
										<a href="updateUser.jsp?id=<%=u.getId()%>&username=<%=u.getName()%>&password=<%=u.getPassword()%>">修改</a>
										<a href="delete.user?id=<%=u.getId()%>" onclick="return confirm(
										'确定删除<%=u.getName()%>吗？')">删除</a>&nbsp;
									</td>
								</tr>
								<%
							}
						}
						%>
						
					</table>
					<p>
						<input type="button" class="button" value="添加用户" onclick="location='insertUser.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
</body>
</html>