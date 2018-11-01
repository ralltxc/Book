<%
	Object obj = session.getAttribute("user");
if(obj==null){
	response.sendRedirect("login.jsp");
	return ;
}
%>

<%@page import="entity.Book"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
							2009/11/20
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
								图示编号ISBN
							</td>
							<td>
								类别
							</td>
							<td>
								图书名称
							</td>
							<td>
								作者
							</td>
							<td>
								出版社
							</td>
							<td>
								出版日期
							</td>
							<td>
								印刷次数
							</td>
							<td>
								单价
							</td>
						</tr>
						<%
							List<Book> books=(List<Book>)request.getAttribute("books");
							for(int i=0;i<books.size();i++){
								Book b = books.get(i);
								%>
							<tr>
								<td>	
									<%=b.getIsbn() %>
								</td>
								<td>
									<%=b.getTypeid() %>
								</td>
								<td>
									<%=b.getBookname() %>
								</td>
								<td>
									<%=b.getAuthor() %>
								</td>
								<td>
									<%=b.getPublish() %>
								</td>
								<td>
									<%=b.getPublishdate() %>
								</td>
								<td>
									<%=b.getPublishtime() %>
								</td>
								<td>
									<%=b.getUnitprice() %>
								</td>
								<td><a href="Updatebook.jsp?isbn=<%=b.getIsbn() %>&typeid=<%=b.getTypeid() %>&bookname=<%=b.getBookname()%>&author=<%=b.getAuthor()%>&publish=<%=b.getPublish()%>&publishdate=<%=b.getPublishdate()%>&publishtime=<%=b.getPublishtime() %>&unitprice=<%=b.getUnitprice()%>">修改</a>
									<a href="del.book?isbn=<%=b.getIsbn() %>" onclick="return confirm('确定删除<%=b.getBookname()%>吗？')">删除</a>&nbsp;
								</td>
							</tr>
								<%
							}
						
						%>
						
					</table>
					<p>
						<input type="button" class="button" value="添加用户" onclick="location='addbook.jsp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				</div>
			</div>
		</div>
	</body>
</html>
