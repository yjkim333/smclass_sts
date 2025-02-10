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
		</style>
		<script>
		
		
		</script>
	</head>
	<body>
		<h2>Main</h2>
		<div>session_id : ${session_id}</div>
		<div>session_name : ${session_name}님, 환영합니다.</div>
		<hr>
		<ul>
			<li><a href="/member/login">로그인 >></a></li>
			<li><a href="/member/member">회원가입 >></a></li>
			<li><a href="/board/blist">게시판 >></a></li>
			<li><a href="/board/boardWrite">게시글 쓰기 >></a></li>
			<li><a href="/board/bview?bno=2">게시글 보기 >></a></li>
			<li><a href="/member/mlist">회원리스트 >></a></li>
			<li><a href="/member/memInfo">회원정보 >></a></li>
			<li><a href="/member/logout">로그아웃 >></a></li>
		</ul>
	</body>
</html>