<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="num" value="123456789"/>
	<!-- 통화 심볼 $ -->
	달러 : <fmt:formatNumber value="${num}" type="currency" currencySymbol="$"/><br/>
	<!-- integerOnly true를 사용하여 정수만 뽑을 수도 있음 -->
	<!-- 0.0000 정수자리, 실수4자리로 값 출력, groupingUsed는 3자리수 마다 콤마 , 여부(기본값 true) -->
	패턴 : <fmt:formatNumber value="${num}" pattern="0.0000" groupingUsed="false"/><p/>
	퍼센트 : <fmt:formatNumber value="${num}" type="percent"/><p/>
	
	<c:set var="dayTime" value="<%=new Date()%>"/>
	날짜 : <fmt:formatDate value="${dayTime}" pattern="yyyy-mm-dd"/><br>
	날짜 : <fmt:formatDate value="${dayTime}" pattern="yyyy년 mm월 dd일"/><br>
</body>
</html>