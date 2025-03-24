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
	<h2>Core Tag2</h2>
	
	<!-- if문 -->
	<c:if test="${param.id != null && param.id != ''}">
		<b>${param.id}</b>님<br>
	</c:if>
	<c:if test="${param.id == ''}">
		<b>Guest</b>님<br>
	</c:if>
	
	<!-- 다중 if -->
	<!-- when:else if / otherwise: else -->
	<!-- 태그 내부에 주석X -->
	<c:choose>
		<c:when test="${param.color=='yellow'}">
			<c:set var="c" value="노란색"/>
		</c:when>
		<c:when test="${param.color=='blue'}">
			<c:set var="c" value="파란색"/>
		</c:when>
		<c:when test="${param.color=='red'}">
			<c:set var="c" value="빨간색"/>
		</c:when>
		<c:when test="${param.color=='pink'}">
			<c:set var="c" value="분홍색"/>
		</c:when>
		
		<c:otherwise>
			<c:set var="c" value="블랙"/>
		</c:otherwise>
	</c:choose>
	choose문 태그를 닫습니다.
	<br>
	좋아하는 색상은 <span style="color: ${param.color}">${c}</span> 입니다.<br>
	
	<!-- 출력이 안되면 아래의 방법 c:out 을 사용 -->
	좋아하는 색상은 <span style="color: ${param.color}"><c:out value="${c}"/></span> 입니다.
</body>
</html>