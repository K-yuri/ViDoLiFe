<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.model.vo.Board, board.model.vo.Comment, java.util.ArrayList"%>
<%
	Board b = (Board)request.getAttribute("board");
	ArrayList<Comment> list = (ArrayList<Comment>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&family=Nanum+Gothic&display=swap" rel="stylesheet">
<title>Insert title here</title>
<style>
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
	
	.contents{
		margin-top:10px;
		border: 1px solid lightgray;
		padding: 20px;
	}
	.board_titleArea{
		text-align:left;
		text-decoration: none;
	}
	
	a{
		color: black;
		text-decoration: none;
	}
	
	.content_part{
		border-bottom: 1px solid lightgray;
		padding-bottom: 10px;
		font-family: 'Nanum Gothic', sans-serif;
		line-height: 150%;
	}
	
	.content_titleArea, .comment_partArea{
		border-bottom: 1px solid lightgray;
		padding-bottom: 10px;
	}
	
	.comment_titleArea{
		padding-bottom: 20px;
		font-size: 20px;
	}
	
	#return_list{
		border: none;
		background: #00CED1;
		font-family: 'Jua', sans-serif;
		height: 25px;
		border-radius: 5px;
	}
	
	.btn{
		border: none;
		background: #00CED1;
		font-family: 'Jua', sans-serif;
		height: 25px;
		width: 50px;
		border-radius: 5px;
	}
	
	#replySelectTable{
		width: 100%;
		margin: 5px;
		padding: 5px;
	}
	
	#replySelectTable td{
		border-bottom: 1px solid lightgray;
	}
	
	#replyWriterTable{
		width: 100%;
		margin: 5px;
		padding: 5px;
	}
	
	#addReply{
		border: none;
		background: #00CED1;
		font-family: 'Jua', sans-serif;
		height: 50px;
		width: 50px;
		border-radius: 5px;
	}
	
	button:hover{cursor: pointer;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

	<div class="contents">
		<div class="board_titleArea">
			<a href="<%= request.getContextPath() %>/list.jo">단체관람 게시판▷</a>
		</div>
		<form action="<%= request.getContextPath() %>/updateJoinForm.jo" id="detailForm" method="post">
		<div class="content_titleArea">
			<!-- 글제목, 사용자프로필, 글작성 날짜 및 시간, 조회수가 들어가는 부분 -->
			<div class="content_title" style="font-size: 20px;">
				<%= b.getBoardTitle() %>
				<input type="hidden" name="title" value="<%= b.getBoardTitle() %>">
			</div>
			
			<br>
			
			<span class="writer_profile"><a href="#"><img src=".\images\propile.png" width="30" height="30"></a></span>
			
			<span class="content_info">
				<span class="nickname">
					<a href="#"><%= b.getNickName() %></a>
					<input type="hidden" name="writer" value="<%= b.getNickName() %>">
				</span>
			<br>
			
			<span class="write_date"><%= b.getBoardDate() %></span>
			<span class="write_time"><%= b.getBoardHour() %> : <%= b.getBoardMin() %> </span>
			<span class="view_count">| 조회수 <%= b.getBoardCount() %></span>
			</span>
		</div>

		<br>

		<div class="content_part">
			<!-- 작성한 글이 들어가는 부분 -->
			<%= b.getBoardContent() %>
			<input type="hidden" name="content" value="<%= b.getBoardContent() %>">
			<input type="hidden" name="bNo" value="<%= b.getBoardNo() %>">
		</div>
		<br>
		<div id="write_button" style="text-align: right;">
			<% if(loginUser.getUserId().equals(b.getBoardWriter())) { %>
			<input class="btn" type="submit" value="수정">
			<input class="btn" type="button" onclick="deleteBoard();" value="삭제">
			<% } %>
		</div>
		
		</form>
		
		<br>
		
		<div class="comment_titleArea"> ▒ 댓글 ▒</div>
		
		<div class="replyArea">
			<div class="replyWriterArea">
				<table id="replyWriterTable">
					<tr>
						<td colspan="3" style="width:95%;"><textarea rows="3" style="width:100%; resize: none; border: 1px solid #00CED1;" id="replyContent"></textarea></td>
						<td style="text-align: left; width:5%;"><button id="addReply">댓글<br>등록</button></td>
					</tr>
				</table>
			</div>
		</div>
		
		<div class="comment_partArea" id="replySelectArea">
			<!-- 댓글에 관련된 부분 -->
			<table id="replySelectTable">
				<% if(list == null) { %>
					<tr><td colspan="3">댓글이 없습니다.</td></tr>
				<% } else { %>
					<% for(int i = 0; i < list.size(); i++) { %>
						<tr>
							<td><a href="#"><img src=".\images\propile.png" width="30" height="30"></a> <%= list.get(i).getNickName() %></td>
							<td><%= list.get(i).getCommentContent() %></td>
							<td><%= list.get(i).getCommentDate() %> <%= list.get(i).getCommentHour() %> : <%= list.get(i).getCommentMin() %></td>
						</tr>
					<% } %>
				<% } %>
			</table>
		</div>

	</div>

	<br>
	<div style="text-align: center;">
		<button id="return_list" onclick="location.href='<%= request.getContextPath() %>/list.jo'">목록으로</button>
	</div>
	<script>
		function deleteBoard() {
			var bool = confirm('정말 삭제하시겠습니까?');
			if(bool) {
				$('#detailForm').attr('action', 'delete.jo');
				$('#detailForm').submit();
			}
		}
		
		$('#addReply').on('click', function() {
			var writer = '<%= loginUser.getUserId() %>';
			var content = $('#replyContent').val();
			var bNo = <%= b.getBoardNo() %>;
			
			$.ajax({
				url: 'insertComment.jo',
				data: {writer:writer, content:content, bNo:bNo},
				success: function(data) {
					console.log(data);
					
					$replyTable = $('#replySelectTable');
					$replyTable.html('');
					
					for(var i in data) {
						var $tr = $('<tr>');
						var $writerTd = $('<td>').text(data[i].nickName).css('width', '100px');
						var $contentTd = $('<td>').text(data[i].commetContent).css('width', '400px');
						var $dateTd = $('<td>').text(data[i].commentDate).css('width', '200px');
						
						$tr.append($writerTd);
						$tr.append($contentTd);
						$tr.append($dateTd);
						$replyTable.append($tr);
					}
					
					$('#replyContent').val('');
					
				},
				error: function(data) {
					console.log(data);
				}
			});
		});
	</script>
</body>
</html>