<%
	Object obj = session.getAttribute("user");
if(obj==null){
	response.sendRedirect("login.jsp");
	return ;
}
%>

<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body style="font-size: 60px;" align="center">
	添加成功
</body>
</html>