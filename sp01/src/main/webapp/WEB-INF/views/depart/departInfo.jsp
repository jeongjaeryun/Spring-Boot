<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>부서 단건 조회</title>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		</head>

		<body>
			<form action="departInsert" method="post">
				<div>
					<label>department_id : <input type="text" name="departmentId" value="${departInfo.departmentId}"> </label>
				</div>
				<div>
					<label>department_name : <input type="text" name="departmentName" value="${departInfo.departmentName}"> </label>
				</div>
				<div>
					<label>manager_id : <input type="text" name="managerId" value="${departInfo.managerId}"> </label>
				</div>
				<div>
					<label>location_id: <input type="text" name="locationId" value="${departInfo.locationId}"> </label>
				</div>
				<div>
					<button type="button" id="updateBtn">수정</button>
					<button type="button"
						onclick="location.href='departDelete?departmentId=${departInfo.departmentId}'">삭제</button>
					<button type="button" onclick="location.href='departList'">목록으로</button>
				</div>
			</form>
			
		</body>

		</html>