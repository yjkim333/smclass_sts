<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title> JARDIN SHOP </title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="JARDIN SHOP" />
<meta name="keywords" content="JARDIN SHOP" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scaleable=no" />
<link rel="stylesheet" type="text/css" href="../css/reset.css?v=Y" />
<link rel="stylesheet" type="text/css" href="../css/layout.css?v=Y" />
<link rel="stylesheet" type="text/css" href="../css/content.css?v=Y" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/top_navi.js"></script>
<script type="text/javascript" src="../js/left_navi.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="../js/idangerous.swiper-2.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.anchor.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {

});
</script>
</head>
<body>
<div id="allwrap">
<div id="wrap">

	<div id="header">
		
		<div id="snbBox">
			<h1><a href="/"><img src="../images/txt/logo.gif" alt="JARDIN SHOP" /></a></h1>
			<div id="quickmenu">
				<div id="mnaviOpen"><img src="../images/btn/btn_mnavi.gif" width="33" height="31" alt="메뉴열기" /></div>
				<div id="mnaviClose"><img src="../images/btn/btn_mnavi_close.gif" width="44" height="43" alt="메뉴닫기" /></div>
				<ul>
					<li><a href="/event/event">EVENT</a></li>
					<li><a href="/customer/notice">CUSTOMER</a></li>
					<li><a href="/community/epilogue">COMMUNITY</a></li>
				</ul>
			</div>
			<div id="snb">
				<ul>
					<li><a href="#">LOGIN</a></li>
					<li><a href="#">JOIN</a></li>
					<li><a href="#">MY PAGE</a></li>
					<li><a href="#">CART</a></li>
				</ul>

				<div id="search">
					<input type="text" class="searchType" />
					<input type="image" src="../images/btn/btn_main_search.gif" width="23" height="20" alt="검색하기" />
				</div>
			</div>
		</div>
	</div>


	<!-- GNB -->
	<div id="gnb">
		
		<div id="top">
			<ul>
				<li class="brand t1"><a href="#" id="topNavi1">JARDIN’s BRAND</a>
					<ul id="topSubm1">
						<li><a href="#">클래스</a></li>
						<li><a href="#">홈스타일 카페모리</a></li>
						<li><a href="#">드립커피백</a></li>
						<li><a href="#">카페리얼 커피</a></li>
						<li><a href="#">오리지널커피백</a></li>
						<li><a href="#">카페리얼 음료</a></li>
						<li><a href="#">마일드커피백</a></li>
						<li><a href="#">워터커피</a></li>
						<li><a href="#">카페포드</a></li>
						<li><a href="#">모히또파티</a></li>
						<li><a href="#">테이크아웃 카페모리</a></li>
						<li><a href="#">포타제</a></li>
					</ul>
				</li>
				<li class="t2"><a href="#" id="topNavi2">원두</a>
					<ul id="topSubm2">
						<li><a href="#">클래스</a></li>
						<li><a href="#">로스터리샵</a></li>
						<li><a href="#">커피휘엘</a></li>
						<li><a href="#">산지별 생두</a></li>
					</ul>
				</li>
				<li class="t1"><a href="#" id="topNavi3">원두커피백</a>
					<ul id="topSubm3">
						<li><a href="#">드립커피 로스트</a></li>
						<li><a href="#">오리지널커피백</a></li>
						<li><a href="#">마일드커피백</a></li>
					</ul>
				</li>
				<li class="t2"><a href="#" id="topNavi4">인스턴트</a>
					<ul id="topSubm4">
						<li><a href="#">까페모리</a></li>
						<li><a href="#">홈스타일카페모리</a></li>
						<li><a href="#">포타제</a></li>
					</ul>
				</li>
				<li class="t1"><a href="#" id="topNavi5">음료</a>
					<ul id="topSubm5">
						<li><a href="#">까페리얼</a></li>
						<li><a href="#">워터커피</a></li>
						<li><a href="#">모히또</a></li>
					</ul>
				</li>
				<li class="t2"><a href="#" id="topNavi6">커피용품</a>
					<ul id="topSubm6">
						<li><a href="#">종이컵</a></li>
						<li><a href="#">커피필터</a></li>
						<li><a href="#">머신 등</a></li>
					</ul>
				</li>
				<li class="t1"><a href="#" id="topNavi7">선물세트</a></li>
				<li class="t2"><a href="#" id="topNavi8">대량구매</a></li>
			</ul>
		</div>

		<script type="text/javascript">initTopMenu();</script>
	</div>
	<!-- //GNB -->

	<!-- container -->
	<div id="container">

		<div id="location">
			<ol>
				<li><a href="/">HOME</a></li>
				<li><a href="/community/epilogue">COMMUNITY</a></li>
				<li class="last">사용 후기</li>
			</ol>
		</div>
		
		<div id="outbox">		
			<div id="left">
				<div id="title2">COMMUNITY<span>커뮤니티</span></div>
				<ul>	
					<li><a href="/community/comment" id="leftNavi1">체험단</a></li>
					<li><a href="/community/epilogue" id="leftNavi2">사용 후기</a></li>
					<li class="last"><a href="#" id="leftNavi3">ENJOY COFFEE</a></li>
				</ul>			
			</div><script type="text/javascript">initSubmenu(2,0);</script>


			<!-- contents -->
			<div id="contents">
				<div id="mypage">
					<h2><strong>사용 후기</strong><span>쟈뎅 제품을 구매하신 회원님들의 소중한 후기입니다.</span></h2>
					
					<div class="productTab normaltab">
						<ul>
							<li><a href="#">포토 구매후기</a></li>
							<li class="last"><a href="#" class="on">상품평</a></li>
						</ul>						
					</div>


					<!-- 상품평 -->
					<div class="orderDiv">
					<table summary="상품평 게시판으로 NO, 제품명, 제목, 작성자, 평점/등록일, 조회수 순으로 조회 하실수 있습니다." class="orderTable" border="1" cellspacing="0">
						<caption>주문 제품 확인</caption>
						<colgroup>
						<col width="8%" class="tnone" />
						<col width="12%" class="tw20" />
						<col width="*" />
						<col width="14%" class="tw20" />
						<col width="14%" class="tnone" />
						<col width="10%" class="tnone" />
						</colgroup>
						<thead>
							<th scope="col" class="tnone">NO.</th>
							<th scope="col">제품명</th>
							<th scope="col">제목</th>
							<th scope="col">작성자</th>
							<th scope="col" class="tnone">평점/등록일</th>
							<th scope="col" class="tnone">조회수</th>
						</thead>
						<tbody class="apiType">
						<script>
						$(function(){
							$.ajax({
								url:"/community/api_comment",
								type:"post",
								data:{},
								dataType:"json",
								success:function(data){
									alert("dd");
									console.log(data.body);
									let apiArr = data.body.items;
									
									hdata = ``;
									for(let i=0;i<4;i++){
										hdata += `
											<tr>
												<td class="tnone">1</td>
												<td>카페모리</td>
												<td class="left">
													<a href="#">
														<span class="orange">[관광]</span> `+apiArr[i].item.title.org+`
														<img src="../images/ico/ico_new.gif" alt="new" />
													</a>
												</td>
												<td>slseifh***</td>
												<td class="tnone">
													<img src="../images/ico/ico_star.gif" alt="별점" />
													<img src="../images/ico/ico_star.gif" alt="별점" />
													<img src="../images/ico/ico_star.gif" alt="별점" />
													<img src="../images/ico/ico_star.gif" alt="별점" />
													<img src="../images/ico/ico_star.gif" alt="별점" />
	
													<br/>14-01-28
												</td>
												<td class="right tnone">9999</td>
											</tr>
										`;
										
									}// for
									$(".apiType").html(hdata);
									
								},
								error:function(){
									alert("api 호춣 실패");
								}
							});// ajax
								
						
						});// jquery
						
						</script>
						<!-- 리스트 반복 -->
							<!-- <tr>
								<td class="tnone">1</td>
								<td>카페모리</td>
								<td class="left">
									<a href="#">
										<span class="orange">[먹어봤어요]</span> 쟈뎅, 테이크아웃 카페모리...
										<img src="../images/ico/ico_new.gif" alt="new" />
									</a>
								</td>
								<td>slseifh***</td>
								<td class="tnone">
									<img src="../images/ico/ico_star.gif" alt="별점" />
									<img src="../images/ico/ico_star.gif" alt="별점" />
									<img src="../images/ico/ico_star.gif" alt="별점" />
									<img src="../images/ico/ico_star.gif" alt="별점" />
									<img src="../images/ico/ico_star.gif" alt="별점" />

									<br/>14-01-28
								</td>
								<td class="right tnone">9999</td>
							</tr> -->
						<!-- 리스트 반복 -->
						</tbody>
					</table>
					</div>

					<div class="btnAreaList">
						<div class="bwright">
							<ul>
								<li><a href="#" class="sbtnMini">글쓰기</a></li>
							</ul>
						</div>

						<!-- 페이징이동1 -->
						<div class="allPageMoving1">

						<a href="#" class="n"><img src="../images/btn/btn_pre2.gif" alt="처음으로"/></a><a href="#" class="pre"><img src="../images/btn/btn_pre1.gif" alt="앞페이지로"/></a>
						<strong>1</strong>
						<a href="#">2</a>
						<a href="#">3</a>
						<a href="#">4</a>
						<a href="#">5</a>
						<a href="#" class="next"><img src="../images/btn/btn_next1.gif" alt="뒤페이지로"/></a><a href="#" class="n"><img src="../images/btn/btn_next2.gif" alt="마지막페이지로"/></a>

						</div>
						<!-- //페이징이동1 -->
					</div>

					<div class="searchWrap">
						<div class="search">
							<ul>
								<li class="web"><img src="../images/txt/txt_search.gif" alt="search" /></li>
								<li class="se">
									<select>
										<option value="" />제목</option>
									</select>
								</li>
								<li><input type="text" class="searchInput" /></li>
								<li class="web"><a href="#"><img src="../images/btn/btn_search.gif" alt="검색" /></a></li>
								<li class="mobile"><a href="#"><img src="../images/btn/btn_search_m.gif" alt="검색" /></a></li>
							</ul>
						</div>
					</div>
					<!-- //상품평 -->

				</div>
			</div>
			<!-- //contents -->

		</div>
	</div>
	<!-- //container -->




	<div id="footerWrap">
		<div id="footer">
			<div id="fnb">
				<ul>
					<li class="left"><a href="#">개인정보취급방침</a></li>
					<li><a href="#">이용약관</a></li>
					<li class="left"><a href="#">이메일무단수집거부</a></li>
					<li><a href="#">고객센터</a></li>
					<li class="left brand"><a href="#">쟈뎅 브랜드 사이트</a></li>
				</ul>
			</div>
			
			<div id="finfo">
				<div id="flogo"><img src="../images/txt/flogo.gif" alt="JARDIN THE COFFEE CREATOR, SINCE 1984" /></div>
				<address>
					<ul>
						<li>㈜쟈뎅</li>
						<li>대표자 윤영노</li>
						<li class="tnone">주소 서울시 강남구 논현동 4-21번지 영 빌딩</li>
						<li class="webnone">소비자상담실 02)546-3881</li>
						<li>사업자등록번호 211-81-24727</li>
						<li class="tnone">통신판매신고 제 강남 – 1160호</li>
						<li class="copy">COPYRIGHT © 2014 JARDIN <span>ALL RIGHTS RESERVED.</span></li>
					</ul>
				</address>

				<div id="inicis"><img src="../images/ico/ico_inicis.png" alt="이니시스 결제시스템" /></div>
			</div>
		</div>
	</div>



</div>
</div>
</body>
</html>