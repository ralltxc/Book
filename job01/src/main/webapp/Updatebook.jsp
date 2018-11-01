<%
	Object obj = session.getAttribute("user");
if(obj==null){
	response.sendRedirect("login.jsp");
	return ;
}
%>

<%@page pageEncoding="utf-8"  contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<title>图书修改系统</title>
		<style type="text/css">
			body{
			text-align: center;
			background-color: #00BFFF;
			margin: 0 auto;
		}
		table{
			text-align: right;
			margin: 0 auto;
		}
		</style>
	</head>
	<body>
		<h1>图书信息修改系统</h1>
		<form action="update.book" method="post">
		<table>
				<tr>
					<td>国际标准书号(ISBN):</td>
					<td><input type="text" name="isbn" value="<%=request.getParameter("isbn")%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>类别编号:</td>
					<td><input type="text" name="typeid" value="<%=request.getParameter("typeid")%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>书籍名称:</td>
					<td><input type="text" name="bookname" value="<%=request.getParameter("bookname")%>"></td>
				</tr>
				<tr>
					<td>作者:</td>
					<td><input type="text" name="author" value="<%=request.getParameter("author")%>"></td>
				</tr>
				<tr>
					<td>出版社:</td>
					<td><input type="text" name="publish" value="<%=request.getParameter("publish")%>"></td>
				</tr>
				<tr>
					<td>出版日期:</td>
					<td><input type="text" name="publishdate" value="<%=request.getParameter("publishdate")%>"></td>
				</tr>
				<tr>
					<td>印刷次数:</td>
					<td><input type="text" name="publishtime" value="<%=request.getParameter("publishtime")%>"></td>
				</tr>
				<tr>
					<td>价格:</td>
					<td><input type="text" name="unitprice" value="<%=request.getParameter("unitprice")%>"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="确认修改" onclick="listbooks.jsp"></td>
				</tr>
			</table>
		</form>
	</body>
</html>