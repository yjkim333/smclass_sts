<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <title>글쓰기</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/write.css">
  <script>
	/* function wbtn(){
   	}*/
  	const wbtn = () =>{
			if($(".id").val().length<1){
				alert("아이디를 입력하세요.");
				$(".id").focus();
				retutn;
			}
			alert("게시글 저장");
			writeFrm.submit();
  	}
		const readUrl = (input) =>{
				if(input.files && input.files[0]){
					var reader = new FileReader();
					reader.onload = function(e){
						document.getElementById("preview").src = e.target.result;
					};
					reader.readAsDataURL(input.files[0]);
				}else{
					document.getElementById("preview").src = "";
				}
		}
  </script>
</head>
<body>
<section>
    <h1>글쓰기</h1>
    <hr>
    <form action="bwrite" name="writeFrm" method="post" enctype="multipart/form-data">
      <table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="id" class="id">
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="btitle">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea name="bcontent" cols="50" rows="10"></textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="files" id="file" onchange="readUrl(this);">
          </td>
        </tr>
        <tr>
        	<th>이미지 미리보기</th>
          <td>
            <img id="preview" style="width:100px">
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="button" onclick="wbtn()" class="write">작성완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='/'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>