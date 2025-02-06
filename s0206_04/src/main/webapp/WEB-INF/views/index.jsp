<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Main</title>
	</head>
	<body>
		<h2>Main Page</h2>
		<c:if test="${session_id == null}">
			<h4>session : 없음</h4>
			<div><a href="/login">Login >></a></div>
			<div><a href="/member">회원가입 >></a></div>
			<div><a href="/stuInput">학생성적입력 >></a></div>
		</c:if>
		<c:if test="${session_id != null}">
			<h4>session : ${session_id}</h4>
			<div><a href="/boardList">게시판 >></a></div>
			<div><a href="/meminfo">회원정보 >></a></div>
			<div><a href="/logout">Logout >></a></div>
		</c:if>
	</body>
</html>