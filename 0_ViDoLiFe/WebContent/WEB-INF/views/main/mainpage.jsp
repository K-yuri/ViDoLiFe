<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<title>Insert title here</title>
<style type="text/css">
	body{
		height: 100%;
		background: ghostwhite;
		margin-left: 10%;
		margin-right: 10%;
		font-family: 'Jua', sans-serif;
	}
	
	header{
		font-family: 'Jua', sans-serif;
	}
	
	#wrap-all{
		min-height: 100%;
		position: relative;
	}
	#wrap{
		padding-bottom: 100%;
		height: 100%;
	}
	
	#logo {width: 200px;}
	#login {text-align: right; font-size: 8px;}
	
	#searchText {
		text-align: right;
		margin-top: 10px;
		margin-bottom: 10px;
		padding: 0px;
	}
	
	#searchWord {
		border: 1px solid #00CED1;
		font-size: 15px;
		width: 300px;
		height: 30px;
	}
	#input {
		border: none;
		background: #00CED1;
		vertical-align: middle;
		font-family: 'Jua', sans-serif;
		width: 50px;
		height: 35px;
	}
	
	#topMenu {
		height: 30px;
		width: 100%;
		margin: 0px;
		padding: 0px;
	}
	#topMenu ul {
		margin: 0px;
		padding: 0px;
	}
	#topMenu ul li {
		list-style: none;
		color: white;
		float: left;
		line-height: 30px;
		vertical-align: middle;
		text-align: center;
	}
	#topMenu .menuLink {
		text-decoration: none;
		color: black;
		display: block;
		font-size: 15px;
		font-weight: bold;
	}
	#topMenu ul li:hover {background-color: ghostwhite;}
	
	#search {background: #AFEEEE; width: 20%;}
	#review {background: #7FFFD4; width: 20%;}
	#allview {background: #40E0D0; width: 20%;}
	#allbuy {background: #48D1CC; width: 20%;}
	#mypage {background: #00CED1; width: 20%;}
	
	#sub {
		width: 100%;
		text-align: center;
		padding: 5px;
	}
	
	#left {
		width: 50%;
		float: left;
	}
	
	#right {
		width: 50%;
		float: right;
	}
	
	#rank {display: inline; border: 1px solid black;}
	#letter {display: inline;border: 1px solid black;}
	.poster{width: 50px; height: 70px; background-color: lightgray;}
	
	.reco_table {width: 100%;}
	
	table.reco_table {
	  	border-collapse: collapse;
	  	text-align: center;
	  	line-height: 1.5;
	  	margin: 20px 10px;
	  	font-size: 12px;
	}
	
	table.reco_table thead th {
	  padding: 10px;
	  font-weight: bold;
	  border-top: 1px solid #ccc;
	  border-bottom: 2px solid #00CED1;
	  background: #AFEEEE;
	}
	table.reco_table tbody th {
	  padding: 10px;
	  font-weight: bold;
	  vertical-align: top;
	  border-bottom: 1px solid #ccc;
	  background: #ececec;
	}
	table.reco_table td {
	  padding: 10px;
	  vertical-align: top;
	  border-bottom: 1px solid #ccc;
	}
	
	#login:hover{cursor: pointer;}
	
	.mainBannerArea {
	  width: 100%;
	  height: 300px;
	  position: relative;
	  display: flex;
	  justify-content: center;
	  background-color: none;
	  margin-top: 5px;
	}

	.fade {
	  -webkit-animation-name: fade;
	  -webkit-animation-duration: 1.5s;
	  animation-name: fade;
	  animation-duration: 1.5s;
	}
	
	@-webkit-keyframes fade {
	  from {opacity: .4} 
	  to {opacity: 1}
	}
	
	@keyframes fade {
	  from {opacity: .4} 
	  to {opacity: 1}
	}

	.prev, .next {
	  cursor: pointer;
	  position: absolute;
	  top: 50%;	
	  width: auto;
	  padding: 16px;
	  margin-top: -22px;
	  color: white;
	  font-weight: bold;
	  font-size: 18px;
	  transition: 0.6s ease;
	  border-radius: 0 3px 3px 0;
	}
	
	.prev {
	  left: 0;
	  border-radius: 3px 0 0 3px;
	}
	
	.next {
	  right: 0;
	  border-radius: 3px 0 0 3px;
	}
	
	.prev:hover, .next:hover {
	  background-color: rgba(0,0,0,0.8);
	}
	
	tbody>tr>td{font-size:  12px;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div id="wrap-all">
		<section id="wrap">
			<section>
				<div class="mainBannerArea" id="mainBanner">
					<div class="slideBanner fade active">
						<a href="http://www.tving.com" target="_black">
						<img height="300px" src=".\images\tving.jpg"></a>
					</div>
					
					<div class="slideBanner fade">
						<a href="http://www.watcha.com" target="_black">
						<img height="300px" src=".\images\watch.png"></a>
					</div>
					
					<div class="slideBanner fade">
						<a href="http://www.disneyplus.com" target="_black">
						<img height="300px" src=".\images\disnep.jpg"></a>
					</div>
					
					<a class="prev" onclick="prevSlide();">&#10094;</a>
					<a class="next" onclick="nextSlide();">&#10095;</a>
				</div>
			</section>
			<br>
			<div id="sub">
				<div id="left">
					<h3>▒ 일간 박스오피스 순위 ▒</h3>
					<hr>
					<div class="daily contaner"></div>
					
					<br><br>
					
					<h3>▒ 주간 박스오피스 순위 ▒</h3>
					<hr>
					<div class="weekly contaner"></div>
					<script>
						var date = new Date();
	
						var m = date.getMonth() + 1;
						if (m < 10) {
							var month = "0" + m;
						} else {
							var month = m + "";
						}
	
						var d = date.getDate() - 1;
						if (d < 10) {
							var day = "0" + d;
						} else {
							var day = d + "";
						}
	
						var y = date.getFullYear();
						var year = y + "";
	
						var result = year + month + day;
						
						$(function() {
							$.ajax({
								url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=2770216db4c7c4ac21bec508a67beeb0&targetDt=" + result + "&itemPerPage=5",
								dataType: "xml",
								success: function(data) {
									var $data = $(data).find("boxOfficeResult>dailyBoxOfficeList>dailyBoxOffice");
									
									if($data.length > 0) {
										var table =  $("<table/>").attr("class", "table").css("width",  "100%");
										
										var thead = $("<thead/>").append($("<tr/>")).append(
												$("<th/>").html("순위"),
												$("<th/>").html("영화 제목"),
												$("<th/>").html("영화 개봉일"),
												$("<th/>").html("누적 매출액"),
												$("<th/>").html("누적 관객수")
										);
										var tbody = $("<tbody/>");
										$.each($data, function(i, o) {
											var $rank = $(o).find("rank").text(); // 순위
											var $movieNm = $(o).find("movieNm").text(); //영화명
											var $openDt = $(o).find("openDt").text();// 영화 개봉일
											var $salesAcc = $(o).find("salesAcc").text();//누적 매출액
											var $audiAcc = $(o).find("audiAcc").text();
											
											var row = $("<tr/>").append(
													
													$("<td/>").text($rank),
													$("<td/>").text($movieNm),
													$("<td/>").text($openDt),
													$("<td/>").text($salesAcc),
													$("<td/>").text($audiAcc));

											tbody.append(row);
										});
										
										table.append(thead);
										table.append(tbody);
										$(".daily").append(table);
									}
								},
								error: function(data) {
									console.log(data);
								}
							});
						});
						
						var wm = date.getMonth() + 1;
						if (wm < 10) {
							var wmonth = "0" + wm;
						} else {
							var wmonth = wm + "";
						}
	
						var wd = date.getDate() - 7;
						if (wd < 10) {
							var wday = "0" + wd;
						} else {
							var wday = wd + "";
						}
	
						var wy = date.getFullYear();
						var wyear = wy + "";
	
						var wresult = wyear + wmonth + wday;
						
						$(function() {
							$.ajax({
								url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml?key=2770216db4c7c4ac21bec508a67beeb0&targetDt=" + wresult + "&itemPerPage=5",
								dataType: "xml",
								success: function(data) {
									var $data = $(data).find("boxOfficeResult>weeklyBoxOfficeList>weeklyBoxOffice");
									
									if($data.length > 0) {
										var table =  $("<table/>").attr("class", "table").css("width",  "100%");
										
										var thead = $("<thead/>").append($("<tr/>")).append(
												$("<th/>").html("순위"),
												$("<th/>").html("영화 제목"),
												$("<th/>").html("영화 개봉일"),
												$("<th/>").html("누적 매출액"),
												$("<th/>").html("누적 관객수")
										);
										var tbody = $("<tbody/>");
										$.each($data, function(i, o) {
											var $rank = $(o).find("rank").text(); // 순위
											var $movieNm = $(o).find("movieNm").text(); //영화명
											var $openDt = $(o).find("openDt").text();// 영화 개봉일
											var $salesAcc = $(o).find("salesAcc").text();//누적 매출액
											var $audiAcc = $(o).find("audiAcc").text();
											
											var row = $("<tr/>").append(
													
													$("<td/>").text($rank),
													$("<td/>").text($movieNm),
													$("<td/>").text($openDt),
													$("<td/>").text($salesAcc),
													$("<td/>").text($audiAcc));

											tbody.append(row);
										});
										
										table.append(thead);
										table.append(tbody);
										$(".weekly").append(table);
									}
								},
								error: function(data) {
									console.log(data);
								}
							});
						});
					</script>
				</div>
				<div id="right">
					<h3>▒ 추천 게시글 ▒</h3>
					<div>
						<%@ include file="../board/bestList.jsp" %>
					</div>
					<script>
						
					</script>
				</div>
			</div>
		</section>
	</div>
	<script>
		$(document).ready(function () {
			$(".slideBanner").not(".active").hide();
			
			setInterval(nextSlide, 6000);
		});
		
		// 이전 슬라이드
		function prevSlide() {
			$(".slideBanner").hide();
			var allSlide = $(".slideBanner");
			var currentIndex = 0;

			$(".slideBanner").each(function(index,item){ 
				if($(this).hasClass("active")) {
					currentIndex = index;
				}
		        
			});

			var newIndex = 0;
		    
			if(currentIndex <= 0) {
				newIndex = allSlide.length-1;
			} else {
				newIndex = currentIndex-1;
			}
	
			$(".slideBanner").removeClass("active");
			$(".slideBanner").eq(newIndex).addClass("active");
			$(".slideBanner").eq(newIndex).show();
	
		}
	
		//다음 슬라이드
		function nextSlide() {
			$(".slideBanner").hide();
			var allSlide = $(".slideBanner");
			var currentIndex = 0;
			
			$(".slideBanner").each(function(index,item){
				if($(this).hasClass("active")) {
					currentIndex = index;
				}
		        
			});
			
			var newIndex = 0;
			
			if(currentIndex >= allSlide.length-1) {
				newIndex = 0;
			} else {
				newIndex = currentIndex+1;
			}
	
			$(".slideBanner").removeClass("active");
			$(".slideBanner").eq(newIndex).addClass("active");
			$(".slideBanner").eq(newIndex).show();
		}
		
		$('#main_table td').mouseenter(function() {
			$(this).parent().css({'background':'darkgray', 'cursor':'pointer'});
		}).mouseout(function() {
			$(this).parent().css('background', 'none');
		}).click(function() {
			var bNo = $(this).parent().children().eq(0).text();
			
			if('<%= loginUser %>' != 'null') {
				location.href='<%= request.getContextPath() %>/detail.re?bNo=' + bNo;
			} else {
				alert('회원만 이용할 수 있는 서비스입니다.');
			}
		});
	</script>
</body>
</html>