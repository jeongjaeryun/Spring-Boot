<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<sec:csrfMetaTags/>
</head>
<body>
	<h1>톱 페이지입니다.</h1>
	<ul>
		<li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
		</sec:authorize>
	</ul>

	<sec:authorize access="isAuthenticated()">
		<%--특정한 권한만 있는사람 보게 하기위해, 어떤 경우에 보여도 됩니다.--%>
		<sec:authentication property="principal.username" />
		<form action="logout" method="post">
		<sec:csrfInput/>
			<button>로그아웃</button>
		</form>
	</sec:authorize>
</body>
</html>