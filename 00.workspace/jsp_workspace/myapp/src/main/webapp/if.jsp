<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String msg;
%>
<%
	request.setCharacterEncoding("utf-8");
	String name=request.getParameter("name");
	String color=request.getParameter("color");
	if(color.equals("blue")){
		msg="파란색";
	}else if(color.equals("red")){
		msg="빨간색";
	}else if(color.equals("orange")){
		msg="주황색";
	}else{
		color="white";
		msg="기타";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="<%=color%>">
	<b><%=name %>이 좋아하는 색은 <b><%=msg%>입니다.</b></b>
</body>
</html>