<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Get방식</h1>
	<form action="GetServlet" method="get">
		msg <input name="msg">
		<input type="submit" value="전송">
	</form>
	
	<h1>Post방식</h1>
	<form action="PostServlet" method="post">
		msg <input name="msg">
		<input type="submit" value="전송">
	</form>
</body>
</html>