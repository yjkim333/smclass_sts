<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<title> JARDIN SHOP </title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="JARDIN" />
<meta name="keywords" content="JARDIN" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scaleable=no" />
<link rel="stylesheet" type="text/css" href="../css/reset.css" />
<link rel="stylesheet" type="text/css" href="../css/content.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<script>
$(function(){
	$(".pwChkBtn").click(function(){
		pwChkFrm.submit();
	});
});
</script>
<style>
a{cursor: pointer;}
</style>
<body>
<div id="layerWrap">

	<div class="inputWrap">
			
		<div class="inputBody">
			<div class="title">비밀번호 확인</div>
			<p class="close"><a onclick="parent.$.fancybox.close();" href="javascript:;"><img src="../images/btn/btn_input_close.gif" alt="닫기" /></a></p>

			<p class="popalert">비밀번호를 입력해주세요.</p>

			<div class="inputBox">					
				<ul>
					<form action="/event/pwCboard?cno=${param.cno}" name="pwChkFrm" method="post">
					<li><label for="">비밀번호</label>
					<input type="password" class="w348" id="" name="cpw" />
					</li>
					</form>
				</ul>
			</div>

			<div class="centerbrn">
				<a class="pwChkBtn">확인</a>
			</div>
		</div>

	</div>


</div>
</body>
</html>