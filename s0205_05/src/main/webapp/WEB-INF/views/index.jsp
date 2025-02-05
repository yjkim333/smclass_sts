<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main</title>
	<style>
	ul,li{list-style: none;}
	</style>
</head>
<body>
	<h2>Main Page</h2>
	
	<ul>
	<c:if test="${session_id == null}">
		<li>로그인하세요</li>
		<br>
		<li><a href="login">로그인</a></li>
	</c:if>
	<c:if test="${session_id != null}">
		<li>session_id : ${session_id}</li>
		<br>
		<li><a href="logout">로그아웃</a></li>
	</c:if>
	</ul>
</body>
</html>