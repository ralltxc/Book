<%
	Object obj = session.getAttribute("user");
if(obj==null){
	response.sendRedirect("login.jsp");
	return ;
}
%>

<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<html>
<head></head>
<body style="font-size:30px">
	<%=request.getAttribute("failed") %>
</body>
</html>