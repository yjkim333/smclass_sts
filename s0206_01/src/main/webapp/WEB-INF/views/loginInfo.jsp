<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>loginInfo</title>
		<style>
			h2,div{text-align: center;}
			table,th,td{border: 1px solid #999; border-collapse: collapse;}
			table{width: 900px; margin: 20px auto; text-align: center;}
			th{height: 40px; background: #ededed;}
			td{height: 34px;}
		</style>
	</head>
	<body>
		<h2>회원정보</h2>
		<div><a href="/">Main >></a></div><br>
		<table>
			<colgroup>
				<col width="50%">
				<col width="50%">
			</colgroup>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
			</tr>
			<tr>
				<td>${ id }</td>
				<td>${ pw }</td>
			</tr>
		</table>
	</body>
</html>