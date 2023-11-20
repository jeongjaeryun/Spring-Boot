<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>단건조회</title>
<style type="text/css">
img{
	width: 500px;
}
body{
	width: 70%;
	margin : 0 auto;
}

</style>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<td>${boardInfo.bno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardInfo.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${boardInfo.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="3" cols="2" style="width: 100px;" readonly> 
			     ${boardInfo.contents }
			     </textarea></td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<c:choose>
				<c:when test="${not empty boardInfo.image }"> <%--c:when 다중 if태그/ test 연산자 eq : ==, ne : != , empty:참조타입-> (list, class타입) , not : 연산식 부정--%>
					<td><img src="<c:url value="/resources/${boardInfo.image }"/>"></td>
				</c:when>
				<c:otherwise>
					<td>파일없음</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<th>작성일자</th>
			<td><fmt:formatDate value="${boardInfo.regdate}" pattern="yyyy / MM / dd"/></td>
		</tr>
	</table>
	<button type="button" onclick="location.href='boardUpdate?bno=${boardInfo.bno}'">수정</button>
	<button type="button" onclick="location.href='boardDelete?bno=${boardInfo.bno}'">삭제</button>
</body>
</html>