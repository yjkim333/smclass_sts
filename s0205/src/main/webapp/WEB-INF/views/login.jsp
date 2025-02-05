<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
		<h2>Login Page</h2>
		<div><a href="/">메인페이지</a></div>
		<br>
		<form action="doLogin" method="post">
		<label>아이디</label>
		<br>
		<input type="text" name="id">
		<br>
		<label>비밀번호</label>
		<br>
		<input type="text" name="pw">
		<br>
		<br>
		<input type="submit" value="로그인">
		</form>
	</body>
</html>