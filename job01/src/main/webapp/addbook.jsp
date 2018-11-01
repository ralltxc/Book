<%
	Object obj = session.getAttribute("user");
if(obj==null){
	response.sendRedirect("login.jsp");
	return ;
}
%>

<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<html>
	<head>
	<style type="text/css">
		body{
			text-align: center;
			background-color: #666;
			margin: 0 auto;
		}
		table{
			text-align: right;
			margin: 0 auto;
		}
	</style>
	<title>图书录入系统</title>
	</head>
	<body>
		<form action="add.book" method="post">
			<h1>图书录入系统</h1>
			<table>
				<tr>
					<td>国际标准书号(ISBN):</td>
					<td><input type="text" name="isbn"></td>
				</tr>
				<tr>
					<td>类别编号:</td>
					<td><input type="text" name="typeid"></td>
				</tr>
				<tr>
					<td>书籍名称:</td>
					<td><input type="text" name="bookname"></td>
				</tr>
				<tr>
					<td>作者:</td>
					<td><input type="text" name="author"></td>
				</tr>
				<tr>
					<td>出版社:</td>
					<td><input type="text" name="publish"></td>
				</tr>
				<tr>
					<td>出版日期:</td>
					<td><input type="text" name="publishdate"></td>
				</tr>
				<tr>
					<td>印刷次数:</td>
					<td><input type="text" name="publishtime"></td>
				</tr>
				<tr>
					<td>价格:</td>
					<td><input type="text" name="unitprice"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="确认录入"></td>
				</tr>
			</table>		
		</form>
	</body>
</html>