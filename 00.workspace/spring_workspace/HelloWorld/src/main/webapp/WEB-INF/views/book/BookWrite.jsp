<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Write</title>
</head>
<body>
	<form method="get" action="/book/BookInfo">
		<label for="title">도서명</label>
		<input id="title" name="title"><br>
		<label for="name">저자명</label>
		<input id="name" name="name"><br>
		<label for="price">가격</label>
		<input id="price" name="price"><br>
		<label for="publisher">출판사명</label>
		<input id="publisher" name="publisher"><br>
		<input type="submit" value="도서찾기">
	</form>
</body>
</html>