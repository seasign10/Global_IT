<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>While Example</h1>
	

<%
	request.setCharacterEncoding("UTF-8");
	String msg=request.getParameter("msg");
	// request.getParameter()는 String으로 받음. String to int
	int number=Integer.parseInt(request.getParameter("number"));
	int count=0;
	while(number>count){
%>
	<b><%=msg %></b>
<%
		count++;
	}
%>
</body>
</html>