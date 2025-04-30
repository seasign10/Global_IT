<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>접근 권한이 없습니다.</h1>
	<p>다시 로그인 해주세요</p>
	<a href="/login">로그인</a>
	
	<h2><c:out value="${SPRING_SECURITY_403EXCEPTION.getMessage()}"/></h2>
	<h2><c:out value="${msg}"/></h2>
	
</body>
</html>