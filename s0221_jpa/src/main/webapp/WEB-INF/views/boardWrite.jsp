<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>BoardWrite</title>
		<style>
			a{text-decoration: none; color: inherit;}
			ul,li{list-style:none; margin-bottom: 10px;}
		</style>
	</head>
	<body>
		<h2>게시글 쓰기</h2>
		<div><a href="/">Main >></a></div><br>
		<hr>
		<form action="boardWrite" method="post">
			<label>제목</label><br>
			<input type="text" name="btitle"><br>
			<label>내용</label><br>
			<textarea rows="20" cols="80" name="bcontent"></textarea><br>
			<label>아이디</label><br>
			<input type="text" name="id"><br>
			<label>파일첨부</label><br>
			<input type="file" name="file"><br>
			<br>
			<input type="submit" value="저장 >" ><br>
		</form>
	
	</body>
</html>