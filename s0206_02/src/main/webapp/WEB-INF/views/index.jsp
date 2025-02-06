<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Main</title>
		<style>
			a{text-decoration: none; color: inherit;}
		</style>
	</head>
	<body>
		<h2>Main Page</h2>
			<div><a href="login">Login >></a></div>
			<br>
			<div><a href="member">회원가입 >></a></div>
			<br>
			<div><a href="board?bno=1&btitle=이벤트안내">게시판 >></a></div>
			<br>
			<div><a href="stuInput">학생성적입력 >></a></div>
			<br>
			<div><a href="meminfo">회원정보 >></a></div>
			<br>
			<div><a href="logout">Logout >></a></div>
	</body>
</html>