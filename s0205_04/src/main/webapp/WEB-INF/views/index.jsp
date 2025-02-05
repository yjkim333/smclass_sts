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
	<div>없어</div>
	</c:if>
	<ul>
		<li><a href="login">로그인</a></li>
		<li><a href="logout">로그아웃</a></li>
	</ul>
</body>
</html>