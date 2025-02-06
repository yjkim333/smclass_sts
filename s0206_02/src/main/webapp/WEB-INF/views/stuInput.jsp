<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생성적입력</title>
	</head>
	<body>
		<h2>학생성적입력 Page</h2>
		<div><a href="/">Main >></a></div>
		<br>
		<form action="stuInput" method="post">
		<label>학번</label><br>
		<input type="text" name="stuno"><br>
		<label>이름</label><br>
		<input type="text" name="name"><br>
		<label>국어점수</label><br>
		<input type="text" name="kor"><br>
		<label>영어점수</label><br>
		<input type="text" name="eng"><br>
		<label>수학점수</label><br>
		<input type="text" name="math"><br>
		<br>
		<input type="submit" value="성적입력 >"><br>
		</form>
	</body>
</html>