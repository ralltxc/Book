<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.*,entity.*,java.text.*,dao.*"%>
<html>
<head>
<title>insert</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
						<br />
					</p>
				</div>
				<div id="topheader">
					<h1 id="title">
						<a href="#">图书信息</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>图书信息</h1>
				<table class="table">
					<tr class="table_header">
						<td>读者ID</td>
						<td>图书ID</td>
						<td>借阅时间<%
								Date date=new Date();
								SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
								out.write(sdf.format(date));
							%></td>
						
						<td>归还时间</td>
					</tr>
					<%
						List<Book> users =  (List<Book>)request.getAttribute("users");
						if (users != null) {
							for (int i = 0; i < users.size(); i++) {
								Book b = users.get(i);
					%>
					<tr class="table_header">
						<td><%=b.getIsbn() %></td>
						<td><%=b.getTypeid()%></td>
						<td><%=b.getBookname()%></td>
						<td><%=b.getAuthor()%></td>
						<td><%=b.getPublish()%></td>
						<td><%=b.getPublishdate()%></td>
						<td><%=b.getPublishtime() %></td>
						<td><%=b.getUnitprice()%></td>
					</tr>
					<%
						}
						}
					%>
				</table>
				<p>
					<input type="button" class=" button" value="借阅" onclick="location='insert.jsp'"/>
				</p>
			</div>
		</div> 
		<div id="footer">
			<div id="footer_bg">ABC@126.com</div>
		</div>
	</div>
</body>
</html>