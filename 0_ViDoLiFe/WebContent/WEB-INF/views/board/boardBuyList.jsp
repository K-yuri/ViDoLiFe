<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, board.model.vo.*" %>
<%
	ArrayList<Board> list = (ArrayList)request.getAttribute("list");
    PageInfo pi = (PageInfo)request.getAttribute("pi");
%>
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
	#board_wrap{
		padding-bottom: 30%;
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
	
	.board_title{
		vertical-align: middle;
		text-align: center;
		border-bottom: 1px solid black;
	}

	.main_table{
		width:100%;
	}
	#board_table, #move_page, #search_area{
		text-align:center;
	}
	
	#write_button{
		text-align: right;
	}
	#wbtn{
		border: none;
		background: #00CED1;
		font-family: 'Jua', sans-serif;
		height: 25px;
		border-radius: 5px;
	}
	
	a{
		color: black;
		text-decoration: none;
	}
	
	table.main_table {
	    border-collapse: collapse;
	  	text-align: center;
	  	line-height: 1.5;
	  	font-size: 12px;
	}
	
	table.main_table thead th {
	  padding: 10px;
	  font-weight: bold;
	  border-top: 1px solid #ccc;
	  border-bottom: 2px solid #00CED1;
	  background: #AFEEEE;
	}
	table.main_table tbody th {
	  padding: 10px;
	  font-weight: bold;
	  vertical-align: top;
	  border-bottom: 1px solid #ccc;
	  background: #ececec;
	}
	table.main_table td {
	  padding: 10px;
	  vertical-align: top;
	  border-bottom: 1px solid #ccc;
	}
	
	#field{
		border: none;
		height: 25px;
		background: #00CED1;
	}
	
	#board_search{
		border: 1px solid #00CED1;
		height: 25px;
	}
	
	#search_btn{
		border: none;
		background: #00CED1;
		font-family: 'Jua', sans-serif;
		height: 25px;
		border-radius: 5px;
	}
	
	#move_page button {
		font-family: 'Jua', sans-serif;
		border: none;
		background: none;
		padding: 0;
		margin: 1px;
	}
	
	button:hover{cursor: pointer;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div id="wrap-all">
		<section id="board_wrap">

			<div class="board_title">
				<h3>▒ 공동구매 게시판 ▒</h3>
			</div>

			<div id="board_table">
				<table class="main_table" id="main_table">
					<thead>
						<tr>
							<th class="post_num"><span>글번호</span></th>
							<th class="post_title">제목</th>
							<th class="post_writer">작성자</th>
							<th class="post_date">작성일</th>
							<th class="post_date">작성시각</th>
							<th class="post_view">조회수</th>
						</tr>
					</thead>
					<tbody>
					<% if(list.isEmpty()) { %>
						<tr>	
							<td colspan="6">조회된 리스트가 없습니다.</td>
						</tr>
						<% } else { %>
						<% for(Board b : list) { %>
						<tr>
							<td class="post_num"><%= b.getBoardNo() %></td>
							<td class="post_title"><%= b.getBoardTitle() %></td>
							<td class="post_writer"><%= b.getNickName() %></td>
							<td class="post_date"><%= b.getBoardDate() %></td>
							<td class="post_time"><%= b.getBoardHour() %> : <%= b.getBoardMin() %></td>
							<td class="post_view"><%= b.getBoardCount() %></td>
						</tr>
						<% } %>
					<% } %>
					</tbody>
				</table>
			</div>
			
			<br>
			
			<% if(loginUser != null) { %>
				<div id="write_button">
					<button id="wbtn" onclick="location.href='<%= request.getContextPath()  %>/writeBuyForm.bu'">글작성</button>
				</div>
			<% } %>
			

			<div id="move_page">
			<!-- 맨 처음 페이지 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.bu?currentPage=1'">&lt;&lt;</button>
			<!-- 이전 페이지 -->
			<button id="beforeBtn" onclick="location.href='<%= request.getContextPath() %>/list.bu?currentPage=<%= pi.getCurrentPage() - 1 %>'">&lt;</button>
			<script>
				if(<%= pi.getCurrentPage()  %> <= 1) {
					$('#beforeBtn').prop('disabled', true);
				}
			</script>
			<!-- 숫자 버튼 -->
			<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
			<% if(p == pi.getCurrentPage()){ %>
					<button id="choosen" disabled><%= p %></button>
			<% 		} else { %>
					<button id="numBtn" onclick="location.href='<%= request.getContextPath() %>/list.bu?currentPage=<%= p %>'"><%= p %></button>
			<% 		} %>
			<% } %>
			<!-- 다음 페이지 -->
			<button id="afterBtn" onclick="location.href='<%= request.getContextPath() %>/list.bu?currentPage=<%= pi.getCurrentPage() + 1 %>'">&gt;</button>
			<script>
				if(<%= pi.getCurrentPage()  %> >= <%= pi.getMaxPage() %>) {
					$('#afterBtn').prop('disabled', true);
				}
			</script>
			<!-- 맨 뒤 페이지 -->
			<button onclick="location.href='<%= request.getContextPath() %>/list.bu?currentPage=<%= pi.getMaxPage() %>'">&gt;&gt;</button>
			</div>

			<br>
			<br>

			<div id="search_area">
				<select id="field" name="field">
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="writer">작성자</option>
				</select>
				<input id="board_search" name="input" type="text" size="30" placeholder="검색어를 입력하세요">
				<button id="search_btn" class="btn">검색</button>
			</div>
		</section>

	</div>
	<script>
		$('#main_table td').mouseenter(function() {
			$(this).parent().css({'background':'darkgray', 'cursor':'pointer'});
		}).mouseout(function() {
			$(this).parent().css('background', 'none');
		}).click(function() {
			var bNo = $(this).parent().children().eq(0).text();
			
			if('<%= loginUser %>' != 'null') {
				location.href='<%= request.getContextPath() %>/detail.bu?bNo=' + bNo;
			} else {
				alert('회원만 이용할 수 있는 서비스입니다.');
			}
		});
		document.getElementById("search_btn").onclick = function(){ //검색 버튼을 누르면 
			var input = document.getElementById("board_search").value; //입력한 값과 선택한 카테고리 값을 보낸다.
			var field = document.getElementById('field').value;
			
			console.log(search);
			console.log(field);
			
			location.href='<%= request.getContextPath() %>/search.bu?field=' + field + '&input=' + input;													
		}
	</script>
</body>
</html>