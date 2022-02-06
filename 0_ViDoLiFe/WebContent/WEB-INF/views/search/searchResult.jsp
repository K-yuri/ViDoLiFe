<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="search.model.vo.Search, java.util.ArrayList"%>
<%
	
	ArrayList<Search> list = (ArrayList<Search>)request.getAttribute("list");       //검색 내용으로 작품검색
	ArrayList<Search> greList = (ArrayList<Search>)request.getAttribute("greList");	//검색내용의  장르로 작품검색
	//String keyserch = (String)request.getAttribute("search");
	
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
	#notice {background: #00CED1; width: 20%;}
	
	
	#inblock{
		   width: 70%; height: 100px;
		   background-color: green;
		   }
		   
		   
	.main{ width: 100%; height: 700px;  margin:0 auto;
		}
		
	.main1{	font-family: 'Jua', sans-serif;
			background-color: #AFEEEE; font-size: 20px;
			width: 90%; height:40px;
			 margin-left: 30px;
			 margin-bottom: 20px;
			 padding-top: 10px;
			 padding-left: 20px;
	}
	.main2{ font-family: 'Jua', sans-serif;
			background-color: #AFEEEE; font-size: 20px;
			width: 90%; height:40px;
			 margin-left: 30px;
			 margin-bottom: 20px;
			 padding-top: 10px;
			 padding-left: 20px;
	}
			
	 .main1_box{ board: 1px solid black;
	 			width: 50%;
  				height: 30%;
  				text-align: center;
  			 	 margin-right: 60px;
  			 	margin: 0 auto;
	}
	
	.main2_box{ board: 1px solid black;
				width: 50%;
  				height: 30%;
  				text-align: center;
  				margin-right: 60px;
  				margin: 0 auto;}
  	  
  	  .image{ width: 170px;
  			height: 220px;
  			 margin-right: 10px;			 
	}
	
	#resultEmp{ font-family: 'Jua', sans-serif;
				font-size: 30px;
	}
	

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
				<li id="review"><a class="menuLink" href="<%= request.getContextPath() %>/list.re">리뷰 게시판</a></li>
				<li id="allview"><a class="menuLink" href="<%= request.getContextPath() %>/list.jo">단체관람 게시판</a></li>
				<li id="allbuy"><a class="menuLink" href="<%= request.getContextPath() %>/list.bu">공동구매 게시판</a></li>
				<li id="notice"><a class="menuLink" href="#">공지사항</a></li>
			</ul>
		</nav>
	</header>
	
	<br>

	<div class="main">
		<br><br>
		<br>
		
		<div class="main1"><%= request.getParameter("search") %> 관련 작품</div>
		<div class="main1_box">
			<% if(list.isEmpty()){ %>
				<div id="resultEmp">검색 결과가 없습니다.</div>
				<% } else{ %>
					<% for(int i = 0; i < 1; i++){ %>						
						<% Search s = list.get(i); %>	
							<a href='<%=request.getContextPath()%>/SerchInfoForm.do?conNo=<%=s.getConNo()%>'>
							<img id="image" class="image" src="images/<%= s.getConPicNewName() %>" ></a>
							<input type="hidden" id="imgConNo" value="<%= s.getConNo() %>">											
							<% } %>
					<% } %>		
			</div><br><br>
			
		<div class="main2"><%=request.getParameter("search") %> 관련 추천 작품</div>
			<div class="main2_box">
				<% if(greList.isEmpty()){ %>
					<div id="resultEmp">검색 결과가 없습니다.</div>
				<% } else{ %>
					<% for(int i = 0; i < 5; i++){ %>											
						<% Search gs = greList.get(i); %>
							<a href='<%=request.getContextPath()%>/SerchInfoForm.do?conNo=<%=gs.getConNo()%>'>
							<img id="image" class="image" src="images/<%= gs.getConPicNewName() %>" ></a>
							<input type="hidden" id="imgConNo" value="<%= gs.getConNo() %>">
						<% } %>
					<% } %>
			</div>
			
			
		</div>

</body>
</html>
