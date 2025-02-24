<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판뷰</title>
		<style>
		  h2{text-align: center;}
		  div{text-align: center;}
		  a{text-decoration: none; color: inherit;}
		  table,th,td{border-collapse: collapse;}
		  table{text-align: center; width:1200px; margin:20px auto;}
		  th{border-bottom:1px solid #ededed; background: #ededed; height:42px; }
		  td{font-size:16px; border-bottom:1px solid #ededed; height:56px; }
		</style>
	</head>
	<body>
	  <h2>게시판뷰</h2>
	  <div><a href="/">Main >></a></div><br>
	  <table>
	    <colgroup>
	      <col width="10%">
	      <col width="*">
	      <col width="10%">
	      <col width="20%">
	      <col width="15%">
	    </colgroup>
	    <tr>
	      <th>번호</th>
	      <th>제목</th>
	      <th>작성자</th>
	      <th>작성일</th>
	      <th>조회수</th>
	    </tr>
	    <tr>
	      <td>${bdto.bno}</td>
	      <td><a href="/">${bdto.btitle}</a></td>
	      <td>${bdto.memberDto.id}</td>
	      <td>${bdto.bdate}</td>
	      <td>${bdto.bhit}</td>
	    </tr>
	  </table>
	 
	
	</body>
</html>