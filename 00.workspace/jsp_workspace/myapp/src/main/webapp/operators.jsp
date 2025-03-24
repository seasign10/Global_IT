<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("J",31);
	pageContext.setAttribute("S",8);
	pageContext.setAttribute("P",22);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL의 Operators</h2>
	<%-- <b>J=${pageScope.J}, S=${pageScope.S}, P=${pageScope.P}</b> --%>
	<b>J=${J}, S=${S}, P=${P}</b><br>
	<hr/>
	<b>산술 연산자</b>
	&#36;{J + S} : ${J+S}<br>
	&#36;{J - S} : ${J-S}<br>
	&#36;{J * S} : ${J*S}<br>
	&#36;{J / S} : ${J/S}<br>
	&#36;{J % S} : ${J%S}<br>
	
	<hr/>
	<b>비교 연산자</b>
	&#36;{J < S} : ${J<S}<br>	
	&#36;{J > S} : ${J>S}<br>	
	&#36;{J <= S} : ${J<S}<br>	
	&#36;{J >= S} : ${J<S}<br>	
	&#36;{(10*10) == 100} : ${(10*10) eq 100}<br>	
	<%--
	&#36;{(10*10) != 100} : ${(10*10) ne 100}<br><%-- 이클립스 버거에 오류로 뜨지만 오류 x --%>
	 --%>
	
	<hr/>
	<b>논리 및 조건 연산자</b>
	&#36;{J > P && P < S} : ${J>P and P<S}<br>	
	&#36;{J > P || P < S} : ${J>P and P<S}<br>	
	&#36;{!(S == P)} : ${not(J==P)}<br>	
	&#36;{(J == S)? "같다" : "다르다"} : ${(J == S)? "같다" : "다르다"}<br>	
	
</body>
</html>