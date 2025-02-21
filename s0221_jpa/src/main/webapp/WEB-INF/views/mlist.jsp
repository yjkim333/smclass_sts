<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원리스트</title>
		<style>
		  h2{text-align: center;}
		  div{text-align: center;}
		  a{text-decoration: none; color: inherit;}
		  table,th,td{border:1px solid #999; border-collapse: collapse;}
		  table{text-align: center; width:1200px; margin:20px auto;}
		  th{background: #efefef; height:40px; }
		  td{height:34px; }
		</style>
	</head>
	<body>
	  <h2>회원리스트</h2>
	  <div><a href="/">Main >></a></div><br>
	  <table>
	    <colgroup>
	      <col width="10%">
	      <col width="10%">
	      <col width="10%">
	      <col width="15%">
	      <col width="10%">
	      <col width="*">
	      <col width="20%">
	    </colgroup>
	    <tr>
	      <th>아이디</th>
	      <th>비밀번호</th>
	      <th>이름</th>
	      <th>전화번호</th>
	      <th>성별</th>
	      <th>취미</th>
	      <th>가입일</th>
	    </tr>
	    <c:forEach items="${list}" var="mdto">
	    <tr>
	      <td><a href="/meminfo?id=${mdto.id}">${mdto.id}</a></td>
	      <td>${mdto.pw}</td>
	      <td>${mdto.name}</td>
	      <td>${mdto.phone}</td>
	      <td>${mdto.gender}</td>
	      <td>${mdto.hobby}</td>
	      <td>${mdto.mdate}</td>
	    </tr>
	    </c:forEach>
	  </table>
	 
	
	</body>
</html>