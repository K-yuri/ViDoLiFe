<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="search.model.vo.Search, java.util.ArrayList"%>
<%	
	Search s = (Search)request.getAttribute("search");
	ArrayList<Search> info = (ArrayList<Search>)request.getAttribute("info"); 
%>
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

	#mainImg { margin:0 auto; }
	
	#mainImg{ margin-left: 22%;
	}
	
	#conActor{background: #AFEEEE;
				margin-left: 10%;
				width: 350px;
	}
	#conGenre{ background: #AFEEEE;
				margin-left: 10%;
				width: 350px;}
	
	#conSummary{ background: #AFEEEE;
				margin-left: 10%;
				width: 350px;
				}
				
	#type{ 
				width: 30%;
				margin-left: 3%;
				padding: 7px 7px 7px 0px;
				<!--border-radius: 10px 10px 10px 10px; -->
				 text-decoration:none;
				 font-size: 15px;
				
				
	}
	
	#conTitle{background: #AFEEEE;
				margin-left: 10%;
				width: 350px;
				font-size: 30px;
	}
	
	a{ text-decoration:none 
	}
	a:visited { color:black; }
	
</style>
</head>
<body>
	<header>
		<div id="login">회원가입 / 로그인</div>
		<div>
			<a href="D:\semi-Project\semi-Project\WebContent\index.html"><img id="logo" src="images/비도라이프시안.png"></a>
		</div>
		<div id="searchText">
			<input type="text" id="searchWord"><button id="input">검색</button>
		</div>
		
		<nav id="topMenu">
			<ul>
				<li id="search"><a class="menuLink" onclick="location.href='<%= request.getContextPath() %>/search.ch'">상세검색</a></li>
				<li id="review"><a class="menuLink"
					href="board_into.html">리뷰 게시판</a></li>
				<li id="allview"><a class="menuLink" href="#">단체관람 게시판</a></li>
				<li id="allbuy"><a class="menuLink" href="#">공동구매 게시판</a></li>
				<li id="mypage"><a class="menuLink" href="#">마이페이지</a></li>
			</ul>
		</nav>
	</header>
	<br><br><br>
	
	    <div id ="mainBox">
			<% for(int i = 0; i < info.size(); i++){ %>
					<% Search sc = info.get(i); %>		
				<img class ="Box" id="mainImg" src="images/<%=sc.getConPicNewName() %>" style="float: left" width='25%' height='20%'>
				<div style="display: inline-block; width: 30%"> 
					<span id="conTitle" style="display:inline-block" ><%=sc.getConTitle() %></span><br><br>
					<span id="conActor" style="display:inline-block" >출연 : <%=sc.getConActor() %></span>
					<span id="conGenre" style="display: inline-block">장르 : <%=sc.getConGenre() %></span>
					<span id="conSummary" style="display: inline-block">줄거리 : <%=sc.getConSummary() %></span><br>
												
				</div><br><br>

				<span id="type">		
					<%  if( sc.getConType().equals("넷플릭스")) 				{ %>
					 			<a href="https://www.netflix.com/kr/" class="button"><img height="50px" src="images\netflix.png"> </a> 
					<% 		} else if(sc.getConType().equals("왓챠")) 		{ %>
								<a href="https://watcha.com/" class="button"><img height="50px" src="images\watch.png"></a>
					<% 		} else if(sc.getConType().equals("디즈니플러스"))   { %>
								<a href="https://www.disneyplus.com/ko-kr" class="button"><img height="50px" src="images\disnep.jpg"></a>
					<% 		} else if(sc.getConType().equals("티빙"))   		{ %>
								<a href="https://www.disneyplus.com/ko-kr" class="button"><img height="50px" src="images\tving.jpg"></a>
					<% 		} 												 %>
				</span>	
				
			<% } %>
		</div> 

	
</body>
</html>