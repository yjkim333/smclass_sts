<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<title>meminfo</title>
		<style>
		h2,div{text-align: center;}
		table,th,td{border: 1px solid #999; border-collapse: collapse;}
		table{width: 900px; margin: 20px auto; text-align: center;}
		th{height: 40px; background: #ededed;}
		td{height: 34px;}
		a{color: inherit; text-decoration: none; cursor: pointer;}
		</style>
		<script>
			const deleteBtn = () =>{
				if(confirm("${mdto.id} 님을 삭제???")){
					$.ajax({
						url:"/memdelete",
						type:"post",
						data:{"id":"${mdto.id}"},
						success:function(data){
							console.log(data);
							alert("회원정보가 삭제되었습니다.");
							location.href = "/mlist";
						},
						error:function(){
							alert("ajax 실패");
						}
					})//ajax
				}
			}
		</script>
	</head>
	<body>
		<h2>가입 회원 정보</h2>
		<div><a href="/">Main >></a></div><br>
		<div><a href="/memupdate?id=${mdto.id}">회원정보 수정 >></a></div><br>
		<div><button onclick="deleteBtn()">회원정보 삭제 >></button></div><br>
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
				<td>${mdto.id}</td>
				<td>${mdto.pw}</td>
				<td>${mdto.name}</td>
				<td>${mdto.phone}</td>
				<td>${mdto.gender}</td>
				<td>${mdto.hobby}</td>
			</tr>
		</table>
	</body>
</html>