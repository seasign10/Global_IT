<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- post 방식 한글 깨짐으로 인한 코드 --%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- StudentDTO 접근 -->
    <jsp:useBean id="bean" class="ch20.StudentDTO" scope="request"/>
    
    <!-- 값 set -->
    <jsp:setProperty name="bean" property="firstName"/>
    <jsp:setProperty name="bean" property="lastName"/>
    <jsp:setProperty name="bean" property="country"/>
    <jsp:setProperty name="bean" property="subject"/>
    
    <!-- 출력 -->
    <b>First Name:</b> ${bean.firstName}<br>
    <b>Last Name:</b> ${bean.lastName}<br>
    <b>Country:</b> ${bean.country}<br>
    <b>Subject:</b> ${bean.subject}<br>

</body>
</html>
