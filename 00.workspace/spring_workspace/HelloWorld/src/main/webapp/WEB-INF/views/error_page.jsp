<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 에러페이지에 세션사용을 false로 만들면서 메모리를 아낄 수 있음  -->
<%@ page session="false" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- el($)로 출력을 했을때 나오지 않는 경우 jstl(c:out)을 사용하면 출력되는 경우가 많음 -->
	<%-- <h4><c:out value="${exception.getMessage()}"></c:out></h4>
	
	<ul>
		<c:forEach items="${exception.getStackTrace()}" var="stack">
			<li>
				<c:out value="${stack}"></c:out>
			</li>
		</c:forEach>
	</ul> --%>
	
	<h1>죄송합니다. 예기치 못한 에러가 발생했습니다.</h1>
	<p>다시 한번 시도해보세요. 같은 에러가 지속적으로 발생하면 관리자에게 문의바랍니다.</p>
	관리자 이메일 : admin@company.com
	
</body>
</html>