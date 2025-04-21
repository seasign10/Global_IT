<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>IT 용어집</h1>
	<form method="get" action="/keyword/add">
		<label for="keyword">keyword</label>
		<input type="text" id="keyword" name="keyword"><br>
		<label for="discription">discription</label>
		<input type="text" id="discription" name="discription"><br>
		<input type="submit" value="추가">
	</form>
</body>
</html>