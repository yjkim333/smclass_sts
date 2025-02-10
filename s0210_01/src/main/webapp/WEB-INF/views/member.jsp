<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<style>
			a{text-decoration: none; color: inherit;}
			ul,li{list-style:none; margin-bottom: 10px;}
		</style>
	</head>
	<body>
		<h2>회원가입</h2>
		<div><a href="/">Main >></a></div><br>
		<hr>
		<form action="member" method="post">
			<label>아이디</label><br>
			<input type="text" name="id"><br>
			<label>비밀번호</label><br>
			<input type="text" name="pw"><br>
			<label>이름</label><br>
			<input type="text" name="name"><br>
			<label>전화번호</label><br>
			<input type="text" name="phone"><br>
			<label>성별</label><br>
			<input type="radio" id="man" name="gender" value="남자">
			<label for="man">남자</label>
			<input type="radio" id="woman" name="gender" value="여자">
			<label for="woman">여자</label><br>
			<label>취미</label><br>
			<input type="checkbox" id="game" value="게임" name="hobby">
			<label for="game">게임</label>
			<input type="checkbox" id="golf" value="골프" name="hobby">
			<label for="golf">골프</label>
			<input type="checkbox" id="swim" value="수영" name="hobby">
			<label for="swim">수영</label>
			<input type="checkbox" id="run" value="달리기" name="hobby">
			<label for="run">달리기</label>
			<input type="checkbox" id="book" value="독서" name="hobby">
			<label for="book">독서</label>
			<br>
			<br>
			<input type="submit" value="회원가입 >" ><br>
		</form>
	
	</body>
</html>