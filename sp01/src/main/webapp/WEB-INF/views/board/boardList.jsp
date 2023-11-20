<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style type="text/css">
body{
	width: 70%;
	margin : 0 auto;
}

</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
			<tbody>
				<c:forEach var="b" items="${boardList}">
					<tr onclick="location.href='boardInfo?bno=${b.bno}'">
						<td>${b.bno }</td>
						<td>${b.title }</td>
						<td>${b.writer }</td>
						<td> 
			             <fmt:formatDate value="${b.regdate}" pattern="yyyy년 MM월 dd일"/>			
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
</body>
</html>