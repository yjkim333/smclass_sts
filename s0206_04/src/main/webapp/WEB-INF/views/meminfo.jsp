<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>meminfo</title>
		<style>
		h2,div{text-align: center;}
		table,th,td{border: 1px solid #999; border-collapse: collapse;}
		table{width: 900px; margin: 20px auto; text-align: center;}
		th{height: 40px; background: #ededed;}
		td{height: 34px;}
		</style>
	</head>
	<body>
		<h2>가입 회원 정보</h2>
		<div><a href="/">Main >></a></div><br>
		<table>
			<colgroup>
			<col width="15%">
			<col width="15%">
			<col width="10%">
			<col width="20%">
			<col width="10%">
			<col width="*%">
			</colgroup>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>성별</th>
				<th>취미</th>
			</tr>
			<tr>
				<td>${mem.id}</td>
				<td>${mem.pw}</td>
				<td>${mem.name}</td>
				<td>${mem.tel}</td>
				<td>${mem.gender}</td>
				<td>${mem.hobby}</td>
			</tr>
		</table>
	</body>
</html>