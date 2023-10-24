<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>사원 단건 조회</title>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		</head>

		<body>
			<form>
				<div>
					<label>employee_id : <input type="text" name="employeeId" value="${empInfo.employeeId}" readonly="readonly">
					</label>
				</div>
				<div>
					<label>first_name : <input type="text" name="firstName" value="${empInfo.firstName}"> </label>
				</div>
				<div>
					<label>last_name : <input type="text" name="lastName" value="${empInfo.lastName}" readonly="readonly">
					</label>
				</div>
				<div>
					<label>email : <input type="text" name="email" value="${empInfo.email}"> </label>
				</div>
				<div>
					<label>hire_date: <input type="date" name="hireDate"
							value='<fmt:formatDate value="${empInfo.hireDate}" pattern="yyyy-MM-dd" />' readonly="readonly"> </label>
				</div>
				<div>
					<label>job_id : <input type="text" name="jobId" value="${empInfo.jobId}" readonly="readonly"> </label>
				</div>
				<div>
					<label>salary : <input type="number" name="salary" value="${empInfo.salary}"> </label>
				</div>
				<div>
					<button type="button" id="updateBtn">수정</button>
					<button type="button" onclick="location.href='empDelete?employeeId=${empInfo.employeeId}'">삭제</button>
					<button type="button" onclick="location.href='empList'">목록으로</button>
				</div>
			</form>
			<script>
				//자바스크립트 버전
				document.querySelector('#updateBtn')
					.addEventListener('click', updateEmpInfo);

				function updateEmpInfo(event) {
					// form 태그 내부의 input을 기반으로 수정할 대상 정보를 가져옴
					let empInfo = getEmpInfo();

					// 해당정보를 기반으로 Ajax - QueryString
					fetch('empUpdate', {
						method: 'post',
						body: new URLSearchParams(empInfo)

					})
						.then(response => response.json())
						.then(result => {
							console.log('QueryString', result)
						})
						.catch(err => console.log(err));

					// 해당정보를 기반으로 Ajax - JSON
					fetch('empUpdateAjax', {
						method: 'post',
						headers: {
							'content-type': 'application/json'
						},
						body: JSON.stringify(empInfo) // 객체를 json으로 변환시켜줌
					})
						.then(response => response.json())
						.then(result => {
							console.log('JSON', result)
						})
						.catch(err => console.log(err));
				};


				function getEmpInfo() {
					let inputList = document.querySelectorAll('form input');

					let objData = {};
					inputList.forEach(tag => {
						objData[tag.name] = tag.value;
					});

					return objData;
				}
			</script>
			<script>
				// jQuery 버전
				$('#updateBtn').on('click', updateEmpInfoAjax);

				function updateEmpInfoAjax(event) {

					let empInfo = getEmpInfoAjax();
					//Ajax -> Query String
					$.ajax('empUpdate', {
						type : 'post',
						data : empInfo
					})
						.done(result => {
							console.log('Query String', result);
						})
						.fail(err => console.log(err));

					//Ajax -> JSON
					$.ajax('empUpdateAjax', {
						type : 'post',
						contentType : 'application/json',
						data : JSON.stringify(empInfo)
					})
						.done(result => {
							console.log('JSON', result);
						})
						.fail(err => console.log(err));

					return false;
				}

				function getEmpInfoAjax(){
					let formDta = $('form').serializeArray(); //form태그 기반으로 사용하는 메소드 태그가 가지고있는 name, value 속성만 끄집어냄
					console.log(formDta);
					//[{name : 'employeeId', value:'1052'}, {name:'', value:''}, ...] name이 key, value가 value

					let objData = {};
					$.each(formDta, (idx,obj)=>{  //jquery each는 무조건 매개변수 2개 필요
						objData[obj.name] = obj.value;
						//{ employeeId: '1052', lastName:'Hong', ...}
					});
					return objData;

				}

			</script>
		</body>

		</html>