<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<ul class="nav">
  <li class="nav-item">
    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }/">Home</a>
  </li> <!-- /:절대경로 localhost/바로다음 , pageContext: jsp가 내장하고있는 객체-->
  <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath }/empList">전체사원조회</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath }/empInsert">사원정보등록</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath }/boardList">익명 게시판 조회</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath }/boardInsert">익명 게시글 등록</a>
  </li>
</ul>