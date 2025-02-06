<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>doStuInput</title>
		<style>
			h2,div{text-align: center;}
			table,th,td{border: 1px solid #999; border-collapse: collapse;}
			table{width: 900px; margin: 20px auto; text-align: center;}
			th{height: 40px; background: #ededed;}
			td{height: 34px;}
		</style>
	</head>
	<body>
		<h2>성적정보</h2>
		<div><a href="/">Main >></a></div><br>
		<table>
			<colgroup>
				<col width="15%">
				<col width="15%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="10%">
				<col width="*">
			</colgroup>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>국어점수</th>
				<th>영어점수</th>
				<th>수학점수</th>
				<th>합계</th>
				<th>평균</th>
			</tr>
			<tr>
				<td>${ stu.stuno }</td>
				<td>${ stu.name }</td>
				<td>${ stu.kor }</td>
				<td>${ stu.eng }</td>
				<td>${ stu.math }</td>
				<td>${ stu.total }</td>
				<td>${ stu.avg }</td>
			</tr>
		</table>
	</body>
</html>