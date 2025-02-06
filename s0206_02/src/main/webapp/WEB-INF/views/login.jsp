<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login</title>
	</head>
	<body>
		<h2>Login Page</h2>
		<div><a href="/">Main >></a></div><br>
		<form action="login" method="post">
		<label>아이디</label><br>
		<input type="text" name="id"><br>
		<label>비밀번호</label><br>
		<input type="password" name="pw"><br>
		<label>국어점수</label><br>
		<input type="text" name="kor"><br>
		<label>영어점수</label><br>
		<input type="text" name="eng"><br>
		<label>수학점수</label><br>
		<input type="text" name="math"><br>
		<br>
		<input type="submit" value="LOGIN >"><br>
		</form>
	</body>
</html>