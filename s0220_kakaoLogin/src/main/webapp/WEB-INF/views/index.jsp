<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Main</title>
		<style>
			a{text-decoration: none; color: inherit;}
			ul,li{list-style:none; margin-bottom: 10px;}
			.aa>img{height:20px;}
		</style>
		<script>
		if("${param.logout}"=="1"){
			alert("로그아웃되었습니다.");
			location.href="/";
		}	
		if("${param.chkBwirte}"=="1"){
			alert("게시글 저장 성공")
			location.href="/";
		}
			
		</script>
	</head>
	<body>
		<h2>Main</h2>
		<div>session_id : ${kakaoProfile_id}</div>
		<div>session_name : ${kakaoProfile_nickname}님, 환영합니다.</div>
		<hr>
		<ul>
			<li><a href="/login">로그인 >></a></li>
			<li><a href="/member/member">회원가입 >></a></li>
			<li><a href="/bwrite">게시글 쓰기 >></a></li>
			<li><a href="/blist">게시판 >></a></li>
			<li><a href="/member/mlist">회원리스트 >></a></li>
			<li><a href="/member/memInfo">회원정보 >></a></li>
			<li><a href="/member/logout">로그아웃 >></a></li>
		</ul>
	</body>
</html>