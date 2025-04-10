<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일기장</title>
</head>
<body>
	<form method="get" action="write.do">
		<label for="weather">날씨</label>
		<input type="text" id="weather" name="weather"/><br>
		<label for="title">제목</label>
		<input type="text" id="title" name="title"/><br>
		<label for="content">내용</label>
		<input type="text" id="content" name="content"/><br>
		<input type="submit" value="일기 작성"/>
	</form>
</body>
</html>