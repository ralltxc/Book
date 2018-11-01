<%
	Object obj = session.getAttribute("user");
if(obj==null){
	response.sendRedirect("login.jsp");
	return ;
}
%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*,entity.*,java.text.*" %>
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
					<div id="rightheader">
							<form action="listtype.bt" method="get">
							<input type="text" name="type">
							<input type="submit" value="查询">
							</form>
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
						图书类型列表
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								编号
							</td>
							<td>
								名称
							</td>
						</tr>
						<%
							List<Booktype> types=(List<Booktype>)request.getAttribute("list");
						if(types!=null){
						for(int i=0;i<types.size();i++){
								Booktype u = types.get(i);
								%>
								<tr class="row<%=i%2+1%>">
									<td>
										<%=u.getTypeid() %>
									</td>
									<td>
										<%=u.getTypename() %>
									</td>
									<td>
										<a href="updateBType.jsp?id=<%=u.getTypeid() %>&typename=<%=u.getTypename() %>">修改</a>
										<a href="del.bt?id=<%=u.getTypeid() %>" onclick="return confirm(
										'确定删除<%=u.getTypename() %>吗？')">删除</a>&nbsp;
									</td>
								</tr>
								<%
							}
						}
						%>
						
					</table>
					<p>
						<input type="button" class="button" value="添加类型" onclick="location='addBType.jsp'"/>
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