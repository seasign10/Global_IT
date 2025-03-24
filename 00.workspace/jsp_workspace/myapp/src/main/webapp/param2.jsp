<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--post방식 한글 깨짐으로 인한 코드 --%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>EL의 Parameter처리</h2>
	name : ${param["name"] }<br>
	hobby : ${paramValues.hobby[0] }
	hobby : ${paramValues.hobby[1] }
	hobby : ${paramValues.hobby[2] }
	hobby : ${paramValues.hobby[3] }
	hobby : ${paramValues.hobby[4] }
</body>
</html>