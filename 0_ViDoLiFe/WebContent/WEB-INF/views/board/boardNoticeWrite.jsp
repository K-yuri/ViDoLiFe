<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8" import="board.model.vo.Board"%>
<%
	Board b = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<title>Insert title here</title>
<style type="text/css">
body {
	height: 100%;
	background: ghostwhite;
	margin-left: 10%;
	margin-right: 10%;
	font-family: 'Jua', sans-serif;
}

header {
	font-family: 'Jua', sans-serif;
}

#wrap-all {
	min-height: 100%;
	position: relative;
}

#wrap {
	padding-bottom: 100%;
	height: 100%;
}

#logo {
	width: 200px;
}

#login {
	text-align: right;
	font-size: 8px;
}

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

#topMenu ul li:hover {
	background-color: ghostwhite;
}

#search {
	background: #AFEEEE;
	width: 20%;
}

#review {
	background: #7FFFD4;
	width: 20%;
}

#allview {
	background: #40E0D0;
	width: 20%;
}

#allbuy {
	background: #48D1CC;
	width: 20%;
}

#mypage {
	background: #00CED1;
	width: 20%;
}

#content_writeArea {
	text-align: center;
}

.title_write {
	border-bottom: 1px solid lightgray;
	text-align: center;
	width: 100%;
}

.content_write {
	width: 100%;
	resize: none;
	line-height: 200%;
	border: 1px solid lightgray;
	outline: none;
}

#pic_btn {
	border: none;
	background: #00CED1;
	font-family: 'Jua', sans-serif;
	margin-left: 90%;
	margin-top: 10px;
	margin-bottom: 10px;
	height: 25px;
	border-radius: 5px;
}

.btn {
	border: none;
	background: #00CED1;
	font-family: 'Jua', sans-serif;
	height: 30px;
	width: 60px;
	border-radius: 5px;
}
</style>
</head>
<body>
	<header>
		<div id="login">회원가입 / 로그인</div>
		<div>
			<a href="<%= request.getContextPath() %>"><img id="logo"
				src=".\images\logo.png"></a>
		</div>
		<div id="searchText">
			<input type="text" id="searchWord">
			<button id="input">검색</button>
		</div>
		<nav id="topMenu">
			<ul>
				<li id="search"><a class="menuLink" href="#">상세검색</a></li>
				<li id="review"><a class="menuLink"
					href="<%= request.getContextPath() %>/list.re">리뷰 게시판</a></li>
				<li id="allview"><a class="menuLink"
					href="<%= request.getContextPath() %>/list.jo">단체관람 게시판</a></li>
				<li id="allbuy"><a class="menuLink"
					href="<%= request.getContextPath() %>/list.bu">공동구매 게시판</a></li>
				<li id="mypage"><a class="menuLink" href="#">공지사항</a></li>
			</ul>
		</nav>
	</header>

	<div id="content_writeArea">
		<div class="title_write">
			<h3>▒ 공지 게시판 글쓰기 ▒</h3>
		</div>

		<br>

		<form action="<%= request.getContextPath() %>/insert.re" method="post"
			id="writeReview" name="writeReview" onsubmit="return insertValidate();">
			<div>
				<textarea name="title" class="content_write" rows="1" cols="100"
					placeholder="제목을 입력하세요."></textarea>
			</div>
			<button id="pic_btn" onclick="picInto()">사진 첨부</button>

			<br>

			<div class="content_part">
				<textarea name="content" class="content_write" rows="20" cols="100"
					placeholder="내용을 입력하세요."></textarea>
			</div>

			<br>
			<button class="btn" type="button"
				onclick="location.href='<%=request.getContextPath()%>/list.re'">취소</button>
			<input class="btn" type="submit" value="등록">
		</form>
	</div>
</body>
</html>