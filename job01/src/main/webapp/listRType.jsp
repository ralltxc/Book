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
						<p>
							<form action="listtype.rt" method="post">
								<input type="text" name="type">
								<input type="submit" value="查询">
							</form>
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
						读者类型列表
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								编号
							</td>
							<td>
								名称
							</td>
							<td>
								最大借阅数量
							</td>
							<td>
								最长借阅天数
							</td>
						</tr>
						<%
							List<ReaderType> types=(List<ReaderType>)request.getAttribute("list");
						if(types!=null){
						for(int i=0;i<types.size();i++){
								ReaderType u = types.get(i);
								%>
								<tr class="row<%=i%2+1%>">
									<td>
										<%=u.getId() %>
									</td>
									<td>
										<%=u.getTypename() %>
									</td>
									<td>
										<%=u.getMaxborrownum() %>
									</td>
									<td>
										<%=u.getLimit() %>
									</td>
									<td>
										<a href="updateRType.jsp?id=<%=u.getId() %>&typename=<%=u.getTypename() %>
										&max=<%=u.getMaxborrownum()%>&limit=<%=u.getLimit()%>">修改</a>
										<a href="del.rt?id=<%=u.getId() %>" onclick="return confirm(
										'确定删除<%=u.getTypename() %>吗？')">删除</a>&nbsp;
									</td>
								</tr>
								<%
							}
						}
						%>
						
					</table>
					<p>
						<input type="button" class="button" value="添加用户" onclick="location='addRType.jsp'"/>
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