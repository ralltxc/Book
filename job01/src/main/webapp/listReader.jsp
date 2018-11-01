<%
	Object obj = session.getAttribute("user");
if(obj==null){
	response.sendRedirect("login.jsp");
	return ;
}
%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="dao.*,entity.*,java.util.*"%>
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
						2009/11/20 <br />
					</p>
				</div>
				<div id="topheader">
					<h1 id="title">
						<a href="#">main</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>用户列表</h1>
				<table class="table">
					<tr class="table_header">
						<td>读者编号</td>
						<td>读者类型</td>
						<td>姓名</td>
						<td>年龄</td>
						<td>性别</td>
						<td>电话</td>
						<td>所在部门</td>
						<td>注册日期</td>
						<td colspan="2">操作</td>
					</tr>
					<%
						ReaderDao read = new ReaderDao();
						List<Reader> reader = read.findAll();
						for (int i = 0; i < reader.size(); i++) {
							Reader r = reader.get(i);
					%>
					<tr class="row1<%=i % 2 + 1%>">
						<td><%=r.getReaderid() %></td>
						<td><%=r.getType()%></td>
						<td><%=r.getName()%></td>
						<td><%=r.getAge()%></td>
						<td><%=r.getSex()%></td>
						<td><%=r.getPhone()%></td>
						<td><%=r.getDept()%></td>
						<td><%=r.getRegedate() %></td>
						<td><a href="del.reader?readerid=<%=r.getReaderid() %>"
							onclick="return confirm('是否确定删除<%=r.getName()%>')">删除</a>&nbsp;</td>
						<td><a
							href="uptReader.jsp?readerid=<%=r.getReaderid() %>
							&type=<%=r.getType()%>
							&name=<%=r.getName()%>
							&age=<%=r.getAge()%>
							&sex=<%=r.getSex()%>
							&phone=<%=r.getPhone()%>
							&dept=<%=r.getDept()%>
							&regdate=<%=r.getRegedate()%>">修改</a></td>
					</tr>
					<%
						}
					%>
				</table>
				<p>
					<input type="button" class="button" value="添加用户"
						onclick="location='addReader.jsp'" />
				</p>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">ABC@126.com</div>
		</div>
	</div>
</body>

</html>