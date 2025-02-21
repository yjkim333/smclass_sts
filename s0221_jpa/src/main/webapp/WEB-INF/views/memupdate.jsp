<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 정보 수정</title>
		<style>
			a{text-decoration: none; color: inherit;}
			ul,li{list-style:none; margin-bottom: 10px;}
		</style>
	</head>
	<body>
		<h2>회원 정보 수정</h2>
		<div><a href="/">Main >></a></div><br>
		<hr>
		<form action="memupdate" method="post">
			<label>아이디</label><br>
			<input type="text" name="id" value="${mdto.id}" readonly><br>
			<label>비밀번호</label><br>
			<input type="password" name="pw" value="${mdto.pw}"><br>
			<label>이름</label><br>
			<input type="text" name="name" value="${mdto.name}"><br>
			<label>전화번호</label><br>
			<input type="text" name="phone" value="${mdto.phone}"><br>
			<label>성별</label><br>
			<input type="radio" id="man" name="gender" value="남자" ${ (fn:contains(mdto.gender,'남자'))?'checked':'' } >
			<label for="man">남자</label>
			<input type="radio" id="woman" name="gender" value="여자" ${ (fn:contains(mdto.gender,'여자'))?'checked':'' }>
			<label for="woman">여자</label><br>
			<label>취미</label><br>
			<input type="checkbox" id="game" value="게임" name="hobby" ${ (fn:contains(mdto.hobby,'게임'))?'checked':'' }>
			<label for="game">게임</label>
			<input type="checkbox" id="golf" value="골프" name="hobby" ${ (fn:contains(mdto.hobby,'골프'))?'checked':'' }>
			<label for="golf">골프</label>
			<input type="checkbox" id="swim" value="수영" name="hobby" ${ (fn:contains(mdto.hobby,'수영'))?'checked':'' }>
			<label for="swim">수영</label>
			<input type="checkbox" id="run" value="달리기" name="hobby" ${ (fn:contains(mdto.hobby,'달리기'))?'checked':'' }>
			<label for="run">달리기</label>
			<input type="checkbox" id="book" value="독서" name="hobby" ${ (fn:contains(mdto.hobby,'독서'))?'checked':'' }>
			<label for="book">독서</label>
			<br>
			<br>
			<input type="submit" value="수정하기 >" ><br>
		</form>
	
	</body>
</html>