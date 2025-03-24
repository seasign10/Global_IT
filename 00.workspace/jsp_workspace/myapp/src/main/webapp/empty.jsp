<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL의 empty</h2>
	parameter "name"의 값 존재 유무 : <b>${empty param.name}</b><br>
	<%-- get방식 --%>
	<a href="empty.jsp?name=hkd">name값이 있는 요청</a><br>
	<a href="empty.jsp?">name값이 없는 요청</a>
</body>
</html>