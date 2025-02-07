<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판리스트</title>
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
	  <h2>게시판리스트</h2>
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
	    <c:forEach items="${list}" var="bdto">
	    <tr>
	      <td>${bdto.bno}</td>
	      <td>${bdto.btitle}</td>
	      <td>${bdto.id}</td>
	      <td>${bdto.bdate}</td>
	      <td>${bdto.bhit}</td>
	    </tr>
	    </c:forEach>
	  </table>
	 
	
	</body>
</html>