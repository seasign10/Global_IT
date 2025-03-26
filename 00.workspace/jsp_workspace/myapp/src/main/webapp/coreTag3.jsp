<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String str1[]={"simba","rorod","tina","poli"};
	String str2="JAVA, JSP; Spring, Android";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 스트립트릿에서 선언된 str1을 page저장소에 arr변수명으로 저장  -->
	<c:set var="arr" value="<%=str1 %>"/>
	
	<c:forEach var="i" items="${arr}">
		${i}<br/>
	</c:forEach>
	<hr>
	
	<!-- 스트립트릿에서 선언된 str2을 page저장소에 s변수명으로 저장 -->
	<c:set var="s" value="<%=str2%>"/>
	<!-- 구분자(delims) 복수개 가능 -->
	<c:forTokens var="st" items="${s}" delims=", ;">
		<b>${st}&nbsp;</b>
	</c:forTokens>
</body>
</html>