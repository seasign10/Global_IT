<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
%>
	<h3>환영합니다. <b><%=id %></b>님</h3>
	비밀번호 : <%=pwd %>
</body>
</html>