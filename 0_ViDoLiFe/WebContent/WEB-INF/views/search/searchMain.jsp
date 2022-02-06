<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');

	body{
		background: ghostwhite;
		margin-left: 10%;
		margin-right: 10%;
		font-family: 'Jua', sans-serif;
	}
	
	header{
		font-family: 'Jua', sans-serif;
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
	
	.mainBoard{	width: 100%; height: 700px;  margin:0 auto;
			}
			
			
	#cate{		width: 100px; height: 65px;
				font-family: 'Jua', sans-serif;					
				background: #AFEEEE;
				text-align: center;					
				border: 1px solid #00CED1;	
				margin-left: 30px;
				margin-top: 10px
			}
			
	#serch_input{font-family: 'Jua', sans-serif;
				width: 75%; height:50px;
				background: #AFEEEE;
				text-align: center;
				font-size:40px;
				border: 1px solid #00CED1;
				margin-left: 10px;
				padding-bottom: 10px
				
			}
	#serch_button{  font-family: 'Jua', sans-serif;
					width:90px; height:60px;
					background:#00CED1;
					font-size:30px;
					border: 1px solid #00CED1;
					margin-left: 10px;
					
	}		
	

						
	.keyward{ border: 1px solid  #00CED1;
				width:95%; height:70px;
				margin-left: 30px;}
				
	.key{float: left; font-size: 20px;
		 margin-top: 20px;
		 margin-left: 30px;
	
	}
	
	
	.popuMovie{ text-align: center;
				width: 100%;
	}
	.font{font-size: 30px;}
	
	.image{  width: 180px; height: 250px;
  			
  			margin-right: 10px;
  	}
	
	
	}
	
			
</style>
</head>
<body>
	<header>
		<div id="login">회원가입 / 로그인</div>
		<div>
			<a href="D:\semi-Project\semi-Project\WebContent\index.html"><img id="logo" src="images/logo.png"></a>
		</div>
		<div style="border:none;"id="searchText">
			<input type="text" id="searchWord"><button id="input">검색</button>
		</div>
		<nav id="topMenu">
			<ul>
				<li id="search"><a class="menuLink" onclick="location.href='<%= request.getContextPath() %>/search.ch'">상세검색</a></li>
				<li id="review"><a class="menuLink" href="<%= request.getContextPath() %>/list.re">리뷰 게시판</a></li>
				<li id="allview"><a class="menuLink" href="<%= request.getContextPath() %>/list.jo">단체관람 게시판</a></li>
				<li id="allbuy"><a class="menuLink" href="<%= request.getContextPath() %>/list.bu">공동구매 게시판</a></li>
				<li id="mypage"><a class="menuLink" href="#">마이페이지</a></li>
			</ul>
		</nav>
	</header>
	<br>
	
	<div class="mainBoard">

		<div class="search"><br><br>
			 <select id="cate" name="cate">
		        <option value="title">작품이름</option>
		        <option value="actor">배우이름</option>
		        <option value="genre">작품장르</option>
		     </select>
		     
			<input id="serch_input" type="text" placeholder="검색창" >
			<button id="serch_button">검색</button>
			
			<script>
			   document.getElementById("serch_button").onclick = function(){ //검색 버튼을 누르면 
			   var search = document.getElementById("serch_input").value; //입력한 값과 선택한 카테고리 값을 보낸다.
			   var cate = document.getElementById('cate').value;
			
				location.href='<%= request.getContextPath() %>/SerchForm.do?cate=' + cate + '&search=' + search; 
																					
				}
			</script>
		</div>
		
		<br>
		
		<div class="keyward">
			<div class="key" id="key1">SF</div>
			<div class="key" id="key2">로맨스</div>
			<div class="key" id="key3">드라마</div>
			<div class="key" id="key4">애니메이션</div>
			<div class="key" id="key4">공포</div>
		</div>
		
		<br><br>
		
		<div class="popuMovie">
		<div class="font" font-size="100px">지금 뜨는 작품</div>
			<img class="image" src="images/오징어게임.jpg"> 
			<img class="image" src="images/모가디슈.jpg">
			<img class="image" src="images/술꾼도시여자들.jpg">
			<img class="image" src="images/DP.jpg">
			<img class="image" src="images/이터널스.jpg">
		</div>			
	</div>
	
	
</body>
</html>