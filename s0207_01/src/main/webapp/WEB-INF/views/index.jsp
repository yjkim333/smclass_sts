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
			if("${param.chk}" == "1")	alert("로그인 되었습니다.");
			if("${param.outChk}" == "1"){
				alert("로그아웃 되었습니다.");
			}
		</script>
	</head>
	<body>
		<h2>Main</h2>
		<hr>
		<ul>
		<c:if test="${session_id == null}">
			<li><a href="/member/login">로그인 >></a></li>
			<li><a href="/member/memInsert">회원가입 >></a></li>
		</c:if>
		<c:if test="${session_id != null}">
			<li><a href="/board/blist">게시판 >></a></li>
			<li><a href="/member/memInfo">회원정보 >></a></li>
			<li><a href="/member/logout">로그아웃 >></a></li>
		</c:if>
		</ul>
	</body>
</html>