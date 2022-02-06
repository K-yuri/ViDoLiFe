<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
		background: ghostwhite;
		margin-left: 10%;
		margin-right: 10%;
		font-family: 'Jua', sans-serif;
	}
	
	<%-- 메뉴 --%>
	header{
		font-family: 'Jua', sans-serif;
	}
	#logo {width: 200px;}
	#login {text-align: right; font-size: 15px;}
	
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
	<%-- 메뉴 --%>	
	
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
		box-shadow: 0px 0px 10px 1px #E6E6E6;
		margin-top: 3px;
	}
	
	#profileContent{
		width: 140px;
		text-align: center;
		right: -47px;
	}
	
	#profileIcon{width: 40px; height: 40px; border-radius: 20px; cursor: pointer; margin-left: 15px;}
	
	#profileContent span{
		display: block;
		line-height: 50px;
		text-decoration: none;
		color: black;
	}
	
	#profileContent span:hover{color: #00CED1; cursor: pointer;}
	
	#notiIcon{width: 40px; height: 40px; border-radius: 20px;}
	
	#notiContent{
		width: 230px; height: 300px;
		right: -85px;
	}
	
	#notiContent td{
		padding: 10px;
	}
	
	.dot{
		display: inline-block;
		width: 10px; height: 10px; border-radius: 5px;
		background: tomato;
		margin-left: 13px;
	}
</style>
</head>
<body>
	<header>
		<%-- 로그인 전 --%>
<!-- 	<div id="login" onclick="location.href='<%= request.getContextPath() %>/loginform.me'" role="button">회원가입/로그인</div> -->
 		
 		<%-- 로그인 후 --%>
 		

		<div class="dropdown" id="profileDropdown">
			<img src="images/profile_photo.png" id="profileIcon" role="button">
			<div class="dropdownContent" id="profileContent">
				<span onclick="location.href='<%= request.getContextPath() %>/myProfile.me'" role="button">내 프로필</span>
				<span onclick="location.href='<%= request.getContextPath() %>/myInfo.me'" role="button">내 정보 보기</span>
				<span onclick="location.href='<%= request.getContextPath() %>/logout.me'">로그아웃</span>
			</div>
		</div>
		
		<div class="dropdown" id="notiDropdown">
			<img src="images/notification_icon.png" id="notiIcon" role="button">
			<div class="dropdownContent" id="notiContent">
				<table>
					<tr>
						<td><div class="dot"></div></td>
						<td>새로운 알림이 없습니다</td>
					</tr>
				</table>
			</div>
		</div>
		
			<div id="login" onclick="location.href='<%= request.getContextPath() %>/loginform.me'" role="button">회원가입/로그인</div>
		
	<%-- 메뉴 --%>	
		<div>
			<a href="D:\semi-Project\semi-Project\WebContent\index.html"><img id="logo" src="images/vidolife_logo.png"></a>
		</div>
		<div id="searchText">
			<input type="text" id="searchWord"><button id="input">검색</button>
		</div>
		<nav id="topMenu">
			<ul>
				<li id="search"><a class="menuLink" href="#">상세검색</a></li>
				<li id="review"><a class="menuLink"
					href="board_into.html">리뷰 게시판</a></li>
				<li id="allview"><a class="menuLink" href="#">단체관람 게시판</a></li>
				<li id="allbuy"><a class="menuLink" href="#">공동구매 게시판</a></li>
				<li id="mypage"><a class="menuLink" href="#">공지사항</a></li>
			</ul>
		</nav>
	<%-- 메뉴 --%>
	</header>
	
	<script>		
		$('.dropdown').click(function(){
			$(this).children().css('display', 'block');
		});
		$('.dropdownContent').mouseleave(function(){
			$(this).css('display', 'none');
		});
	</script>
</body>
</html>