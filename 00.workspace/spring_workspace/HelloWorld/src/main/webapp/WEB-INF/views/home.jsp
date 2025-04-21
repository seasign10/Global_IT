<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>수업</h1>
	<a href="/sample/basicGet">basicGet</a>
	<a href="/sample/basicOnlyGet">basicGetOnly</a>
	<a href="/sample/ex01?name=홍길동&age=25">ex01</a>
	<a href="/sample/ex02?name=박문수&age=30">ex02</a>
	<a href="/sample/ex04?name=심사임당&age=40&page=10">ex04</a>
	<a href="/sample/ex05">ex05</a>
	<a href="/sample/ex06">ex06</a>
	<a href="/sample/ex07">ex07</a>
	<a href="/sample/exUpload">exUpload</a>
	
	<!-- 에러페이지 발생을 위한 링크  -->
	<a href="/sample/ex04?name=1&age=a">에러발생</a>
	
	<br>
	<h1>과제</h1>
	<a href="/book/BookWrite">Book</a>
</body>
</html>
