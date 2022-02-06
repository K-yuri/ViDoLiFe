<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member" %>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<style>
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
	#login {text-align: right; font-size: 15px; cursor: pointer;}
	
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
	
	.dropdown{
		position: relative;
		display: inline-block;
 		float: right;
 		margin-top: 5px;
	}
	
	.dropdownContent{
		display: none;
		position: absolute;
		z-index: 1;
		background-color: #F8F8FF;
		border-radius: 5px;
		box-shadow: 0px 0px 15px 1px #D8D8D8;
		margin-top: 3px;
	}
	
	#profileContent{
		width: 140px;
		text-align: center;
		right: -47px;
	}
	
	#profileIcon{width: 40px; height: 40px; border-radius: 20px; cursor: pointer; margin-left: 20px;}
	
	#profileContent span{
		display: block;
		line-height: 50px;
		text-decoration: none;
		color: black;
	}
	
	#profileContent span:hover{color: #00CED1; cursor: pointer;}
	
	#notiIcon{
		width: 40px; height: 40px; border-radius: 20px;
		
	}
	
	#notiContent{
		width: 230px; height: 300px;
		right: -85px;
		padding: 10px;
	}
	
 	#notiContent td{
 		padding: 5px;
 	}
	
	.dot{
		width: 10px; height: 10px; border-radius: 5px;
		background: tomato;
	}
	
	.listDot{display: inline-block;}
	
	#notiDot{
		position: absolute; right: -2px; top: 30px;
	}
	
	.xBtn{
 		background: #AFEEEE;
		border: none;
		color: gray;
		border-radius: 5px;
		cursor: pointer;
	}
</style>
</head>
<body>
	<header>
		<%-- 로그인 전 --%>
<!-- 	<div id="login" onclick="location.href='<%= request.getContextPath() %>/loginform.me'" role="button">회원가입/로그인</div> -->
 		
 		<%-- 로그인 후 --%>
 		<% if(loginUser != null){ %>

		<div class="dropdown" id="profileDropdown">
			<img src="images/propile.png" id="profileIcon" role="button">
			<div class="dropdownContent" id="profileContent">
				<span onclick="location.href='<%= request.getContextPath() %>/myProfile.me'" role="button">내 프로필</span>
				<span onclick="location.href='<%= request.getContextPath() %>/myInfo.me'" role="button">내 정보 보기</span>
				<span onclick="location.href='<%= request.getContextPath() %>/logout.me'">로그아웃</span>
			</div>
		</div>
		
		
		<div class="dropdown" id="notiDropdown">
			
			<img src="images/noti.png" id="notiIcon" role="button">
			<div class="dot" id="notiDot"></div>
			<div class="dropdownContent" id="notiContent">
				<table id="notiTable">
					<tr>
					</tr>
				</table>
			</div>
		</div>
		<% } else { %>
			<div id="login" onclick="location.href='<%= request.getContextPath() %>/loginform.me'" role="button">회원가입/로그인</div>
		<% } %>
	<%-- 메뉴 --%>	
		<div>
			<a href="<%= request.getContextPath() %>"><img id="logo" src="images/logo.png"></a>
		</div>
		<div id="searchText">
			<input type="text" id="searchWord"><button id="input">검색</button>
		</div>
		<nav id="topMenu">
			<ul>
				<li id="search"><a class="menuLink" href="<%= request.getContextPath() %>/search.ch">상세검색</a></li>
				<li id="review"><a class="menuLink" href="<%= request.getContextPath() %>/list.re">리뷰 게시판</a></li>
				<li id="allview"><a class="menuLink" href="<%= request.getContextPath() %>/list.jo">단체관람 게시판</a></li>
				<li id="allbuy"><a class="menuLink" href="<%= request.getContextPath() %>/list.bu">공동구매 게시판</a></li>
				<li id="mypage"><a class="menuLink" href="#">공지사항</a></li>
			</ul>
		</nav>
	</header>
	
	<script>		
		$('.dropdown').click(function(){
			$(this).children().css('display', 'block');
		});
		$('.dropdownContent').mouseleave(function(){
			$(this).css('display', 'none');
		});
		
		<%-- 알림 관련 --%>
		$('#notiDot').css('visibility', 'hidden');
		
		function getNoti(){
			$.ajax({
				url: 'noti.me',
				type: 'GET',
				dataType: 'json',
				success: function(data){
					console.log('success');
					console.log(data.length);
					
					var $notiTable = $('#notiTable');
					
					if(data.length <= 0){
						var $tr = $('<tr>');
						var $dotTd = $('<td>').append("<div class='dot listDot'></div>");
						var $notiTd = $('<td>').text('새로운 알림이 없습니다.');
						
						$tr.append($dotTd);
						$tr.append($notiTd);
						
						$notiTable.append($tr);
					} else {
						$('#notiDot').css('visibility', 'visible');
						
						for(var i in data){
							var $tr = $('<tr>');
							var notiNo = data[i].notiNo;
							var $xTd = $('<td>').append("<input type='button' class='xBtn' value='x' onclick='check(" + notiNo + ");'>")
							
							if(data[i].notiType == 'BOARD'){
								var $notiTd = $('<td>').text(data[i].notiFromUserNick + " 님이 새로운 글 [" + data[i].boardTitle + "]을 작성하였습니다.");
							} else {
								var $notiTd = $('<td>').text(data[i].notiFromUserNick + " 님이 내 글 [" + data[i].boardTitle + "]에 새로운 댓글을 작성하였습니다.");
							}
							
							$tr.append($notiTd);
							$tr.append($xTd);
							
							$notiTable.append($tr);
						}
					
					}
					
				}
			});
		}
		
		<% if(loginUser != null) { %>
			getNoti();
		<% } %>
		
		function check(value){
			var notiNo = value;
			$.ajax({
				url: 'checkNoti.me',
				data: {notiNo:notiNo},
				success: function(data){
					console.log('success');
					
					var $notiTable = $('#notiTable');
					$notiTable.html('');
					getNoti();
				}
// 				error: function(data){
// 					console.log('fail');
// 				}
			});
		}
		
	</script>
</body>
</html>