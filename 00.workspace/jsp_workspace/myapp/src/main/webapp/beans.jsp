<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- bean 접근 -->
<jsp:useBean id="bean" class="ch20.ELBean"/>
<!-- 값 set -->
<jsp:setProperty name="bean" property="siteName"/>

<!-- 출력 방식 -->
사이트명 : <jsp:getProperty name="bean"  property="siteName"/><br>
사이트명 : ${bean.siteName}<br> 

<!-- 자바코드 사용 자제 -->
<%
/* ch20.ELBean bean=new ch20.ELBean();
bean.setSiteName("naver");
out.println("사이트명 : "+bean.getSiteName()+"<br>"); */
%>

</body>
</html>