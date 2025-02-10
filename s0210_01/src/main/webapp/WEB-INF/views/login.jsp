<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login</title>
		<style>
			a{text-decoration: none; color: inherit;}
			ul,li{list-style:none; margin-bottom: 10px;}
		</style>
		<script>
			if("${chkLogin}" == "0"){
				alert("아이디 또는 패스워드가 일치하지 않습니다. 다시 로그인해주세요.");
			}
			if("${session_id}"!=""){
				alert("로그인이 되었습니다.");
				location.href = "/";
			}
		</script>
	</head>
	<body>
		<h2>Login</h2>
		<div><a href="/">Main >></a></div><br>
		<hr>
		<form action="./login" method="post">
		<label>아이디</label><br>
		<input type="text" name="id"><br>
		<label>비밀번호</label><br>
		<input type="password" name="pw"><br>
		<br>
		<input type="submit" value="LOGIN >"><br>
		</form>
	</body>
</html>