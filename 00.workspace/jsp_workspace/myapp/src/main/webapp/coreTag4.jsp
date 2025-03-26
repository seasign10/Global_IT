<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Core Tag - import, url, param</h2>
	<hr>
	<c:import url="coreTag2.jsp">
		<c:param name="id" value="JSPStudy"></c:param>
		<c:param name="color" value="orange"></c:param>
	</c:import>
	<hr>
	<c:url var="url1" value="https://www.google.co.kr/search">
		<c:param name="q" value="JSPStudy"></c:param>
		<c:param name="safe" value="off"></c:param>
	</c:url>
	<a href="${url1}">JSPStudy</a><br>
	<!-- 위와 동일한 코드역할을 함 -->
	<a href="https://www.google.co.kr/search?q=JSPStudy&safe=off">JSPStudy</a>
</body>
</html>