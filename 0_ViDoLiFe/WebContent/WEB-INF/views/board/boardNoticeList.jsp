<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8" import="java.util.ArrayList, board.model.vo.*"%>
<% 
	ArrayList<Board> list = (ArrayList)request.getAttribute("list");
	ArrayList<Board> search = (ArrayList)request.getAttribute("search");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
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
		margin-right: 10px;
		border-radius: 5px;
	}
	#input {
		border: none;
		background: #00CED1;
		vertical-align: middle;
		font-family: 'Jua', sans-serif;
		width: 50px;
		height: 33px;
		border-radius: 5px;
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
	
	/* ????????? ??? ?????? */
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
	#deleteNoBtn{
		border: none;
		background: #00CED1;
		font-family: 'Jua', sans-serif;
		height: 25px;
		border-radius: 5px;
	}
	
	#a{
		color: black;
		text-decoration: none;
	}
	
	table.main_table {
	    border-collapse: collapse;
	  	text-align: left;
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
	  vertical-align: top;
	  border-bottom: 1px solid #ccc;
	}
	table.main_table td {
	  padding: 10px;
	  vertical-align: top;
	  border-bottom: 1px solid #ccc;
	}
	
	#choose{
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
				<h3>??? ?????? ????????? ?????? ???</h3>
			</div>

			<div id="board_table">
				<table class="main_table">
				<% if(loginUser != null){ %>
				<% 		if(loginUser.getUserId().equals("admin")) {%>
						<thead>
							<tr>
								<th class="post_num"><span>?????????</span></th>
								<th class="post_title">??????</th>
								<th class="post_writer">?????????</th>
								<th class="post_date">?????????</th>
								<!-- <th class="post_time">????????????</th> -->
								<th class="post_view">?????????</th>
								<th class="post_report">?????? ??????</th>
								<th class="post_delete">??????</th>
							</tr>
						</thead>
						<tbody>
							<% if(list.isEmpty()){ %>
							<tr>
							<td colspan="5">???????????? ??????????????? ????????????.</td>
							</tr>
							<% } else{%>
							<%		for(Board b : list) { %>
							<tr>
								<td><%= b.getBoardNo() %></td>
								<td><%= b.getBoardTitle() %></td>
								<td><%= b.getNickName() %></td>
								<td><%= b.getBoardDate() %></td>
								<td><%= b.getBoardCount() %></td>
								<td class="post_reportNum"><%= b.getBoardReport() %></td>
								<th class="post_delete"><input type="checkbox" name="post_del" id="delete" value="<%= b.getBoardNo() %>"></td>
							</tr>
							<%		} %>
							<% } %>
						</tbody>
				<% 		} else{ %>
						<thead>
							<tr>
								<th class="post_num"><span>?????????</span></th>
								<th class="post_title">??????</th>
								<th class="post_writer">?????????</th>
								<th class="post_date">?????????</th>
								<th class="post_time">????????????</th>
								<th class="post_view">?????????</th>
							</tr>
						</thead>
						<tbody>
							<% if(list.isEmpty()){ %>
							<tr>
							<td colspan="5">???????????? ??????????????? ????????????.</td>
							</tr>
							<% } else{%>
							<%		for(Board b : list) { %>
							<tr>
							<td class="post_num"><%= b.getBoardNo() %></td>
							<td class="post_title"><%= b.getBoardTitle() %></td>
							<td class="post_writer"><%= b.getNickName() %></td>
							<td class="post_date"><%= b.getBoardDate() %></td>
							<td class="post_time"><%= b.getBoardHour() %> : <%= b.getBoardMin() %></td>
							<td class="post_view"><%= b.getBoardCount() %></td>
							</tr>
							<%		} %>
							<% } %>
						</tbody>
				<% 		} %>
				<% } else{%>
					<thead>
						<tr>
							<th class="post_num"><span>?????????</span></th>
							<th class="post_title">??????</th>
							<th class="post_writer">?????????</th>
							<th class="post_date">?????????</th>
							<th class="post_time">????????????</th>
							<th class="post_view">?????????</th>
						</tr>
					</thead>
					<tbody>
						<% if(list.isEmpty()){ %>
						<tr>
						<td colspan="5">???????????? ??????????????? ????????????.</td>
						</tr>
						<% } else{%>
						<%		for(Board b : list) { %>
							<tr>
							<td class="post_num"><%= b.getBoardNo() %></td>
							<td class="post_title"><%= b.getBoardTitle() %></td>
							<td class="post_writer"><%= b.getNickName() %></td>
							<td class="post_date"><%= b.getBoardDate() %></td>
							<td class="post_time"><%= b.getBoardHour() %> : <%= b.getBoardMin() %></td>
							<td class="post_view"><%= b.getBoardCount() %></td>
							</tr>
						<%		} %>
						<% } %>
					</tbody>
				<% }%>
				</table>
			</div>


			<div id="write_button">
				<br>
				<%if(loginUser != null && loginUser.getUserId().equals("admin")) { %>
				<button id="wbtn" onclick="location.href='<%= request.getContextPath() %>/noticewriter.bo'">?????????</button>
				<button id="deleteNoBtn" value="??????" onclick="delectNotice();">??????</button>
				<% } %>
			</div>

			<div id="move_page">
			<!-- ??? ???????????? -->
			<button onclick="location.href='<%= request.getContextPath() %>/boardnotice.no?currentPage=1'">&lt;&lt;</button>
			<!-- ?????? ???????????? -->
			<button id="beforeBtn" onclick="location.href='<%= request.getContextPath() %>/boardnotice.no?currentPage=<%= pi.getCurrentPage() - 1 %>'">&lt;</button>
			<script>
				if(<%= pi.getCurrentPage() %> <= 1){
					$('#beforeBtn').prop('disabled', true);
				}
			</script>
			<!-- ?????? ?????? -->
			<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++){%>
			<%		if(p == pi.getCurrentPage()){ %>
						<button id="choosen" disabled><%= p %></button>
			<%		} else{ %>	
						<button id="numBtn" onclick="location.href='<%= request.getContextPath() %>/boardnotice.no?currentPage=<%= p %>'"><%= p %></button>	
			<%		} %>
			<% } %>
			<!-- ?????? ???????????? -->
			<button id="afterBtn"onclick="location.href='<%= request.getContextPath() %>/boardnotice.no?currentPage=<%= pi.getCurrentPage() + 1 %>'">&gt;</button>
			<script>
				if(<%= pi.getCurrentPage() %> >= <%= pi.getMaxPage() %>){
					$('#afterBtn').prop('disabled', true);
				}
			</script>
			<!-- ??? ????????? -->
			<button onclick="location.href='<%= request.getContextPath() %>/boardnotice.no?currentPage=<%= pi.getMaxPage() %>'">&gt;&gt;</button>
			</div>
			
			<br>
		
			<div id="search_area">
				<form>
					<select id="choose" name="choose">
						<option value="1">??????+??????</option>
						<option value="2">??????</option>
						<option value="3">??????</option>
						<option value="4">?????????</option>
					</select> <input id="board_search" type="text" size="30"
						placeholder="???????????? ???????????????"> <input id="search_btn"
						type="submit" value="??????">
				</form>
			</div>
		</section>
	</div>
	
	<script>
		// ????????? ????????????
		$('.main_table td').mouseenter(function() {
			$(this).parent().css({'background':'darkgray', 'cursor':'pointer'});
		}).mouseout(function() {
			$(this).parent().css('background', 'none');
		}).click(function() {
			var bNo = $(this).parent().children().eq(0).text();
			
			if('<%= loginUser %>' != 'null') {
				location.href='<%= request.getContextPath() %>/detail.no?bNo=' + bNo;
			} else {
				alert('????????? ????????? ??? ?????? ??????????????????.');
			}
		});
		
		// ????????????
		function delectNotice(){
			var valueArr = '';
			var list = $("input[name='post_del']");
			for(var i = 0; i < list.length; i++){
				if(list[i].checked){
					 valueArr += list[i].value + ' ';
					 console.log(valueArr);
				}
			}
			if(valueArr == ' '){
				alert("????????? ?????? ????????????.");
			} else{
				var chk = confirm("?????? ?????????????????????????");
				$.ajax({
					url : "CheckDelete.bo",
					type : 'POST',
					data : {valueArr : valueArr},
					success: function(jdata){
						if(jdata = 1){
							alert("?????? ??????");
							location.replace("list.no");
						} else{
							alert("?????? ??????")
						}
					},
					error : function(jdata){
						console.log(jdata);
					}
				});
			}
		}
	</script>
</body>
</html>