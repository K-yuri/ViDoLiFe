<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Subscribe,board.model.vo.Board,board.model.vo.PageInfo,java.util.ArrayList" %>
<%
	Member m = (Member)request.getAttribute("member");
	Subscribe sub = null;
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#outer{
		margin-left: 20%;
		margin-right: 20%;
	}
	
	#inner{
		position: relative; top: 20px; left: 20px;
		display: inline-block;
		
	}
	
	#inner span{line-height: 30px;}
	
	.profilePhoto{
 		position: relative; top: 30px;
		width: 100px; height: 100px; border-radius: 50px;
	}
	
	#nickname{
		font-size: 120%;
		line-height: 20px;
	}
	
	.subscribeList:hover{color: #00CED1; cursor: pointer;}
	
	#profileMessage{min-height: 50px;}
	
	.btn{
		float: right;
		border: none;
		font-family: 'Jua', sans-serif;
		height: 25px;
		border-radius: 5px;
		cursor: pointer;
	}
	
	#subscribing{background: #00CED1;}
	#subscribed{background: lightgray;}
	
	/* 게시판 */
	table.main_table {
		width: 110%;
	    border-collapse: collapse;
	  	text-align: left;
	  	line-height: 1.5;
/* 	  	margin: 20px 10px; */
	  	font-size: 12px;
	  	position: relative; left: -25px;
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
	/* 게시판 */
	
	#move_page button {
		font-family: 'Jua', sans-serif;
		border: none;
		background: none;
		padding: 0;
		margin: 1px;
	}
	
	button:hover{cursor: pointer;}
	
	#board_table td{cursor: pointer;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<%
		if(!loginUser.getUserId().equals(m.getUserId())) {
			sub = (Subscribe)request.getAttribute("subscribe");
		}
	%>
	
	<div id="outer">
		<% if(m.getUserPicNew() == null) { %>
			<img src="images/profile.png" class="profilePhoto">
		<% } else { %>
			<img src="<%= request.getContextPath() %>/uploadFiles/<%= m.getUserPicNew() %>" class="profilePhoto">
		<% } %>
		<div id="inner">
			<br>
			<span id="nickname"><%= m.getUserNick() %></span><br>
			
			<% if(loginUser.getUserId().equals(m.getUserId())) { %>
				<span class="subscribeList" onclick="location.href='<%= request.getContextPath() %>/subList.me'">구독 회원</span><br>
			<% } else { %>
				<span class="subscribeList" onclick="location.href='<%= request.getContextPath() %>/subList.me?userId=' + 
				'<%= m.getUserId() %>'">구독 회원</span><br>
			<% } %>
			
			<span id="profileMessage"><%= m.getUserProfileMsg() == null ? "&nbsp;" : m.getUserProfileMsg() %></span>
		</div>
		<% if(!loginUser.getUserId().equals(m.getUserId())) { %>
			<form id="subForm" action="<%= request.getContextPath() %>/subscribe.me?page=profile" method="post">
			<input type="hidden" name="fromUser" value="<%= loginUser.getUserId() %>">
			<input type="hidden" name="toUser" value="<%= m.getUserId() %>">
			<input type="hidden" name="pageUser" value="<%= m.getUserId() %>">
			<% if(sub == null) { %>
				<input type="submit" class="btn" id="subscribing" value="구독하기">
			<% } else { %>
				<input type="button" class="btn" id="subscribed" value="&nbsp;구독 중&nbsp;">
			<% } %>
			</form>
		<% } %>
		<br><br><br><br>
		
		<!-- 게시판 -->
		<div id="board_table">
			<table class="main_table">
				<thead>
				<tr>
					<th class="post_num"><span>글번호</span> </th>
					<th class="post_title">제목</th>
					<th class="post_writer">작성자</th>
					<th class="post_date">작성일</th>
					<th class="post_time">작성시각</th>
					<th class="post_view">조회수</th>
				</tr>
				</thead>
				<tbody>
				<% if(list.isEmpty()){ %>
				<tr>
					<td colspan="6">조회된 게시글이 없습니다.</td>
				</tr>
				<% } else { %>
					<% for(int i = 0; i < list.size(); i ++){ %>
					<tr>
						<input type="hidden" value="<%= list.get(i).getBoardClass() %>">
						<td><%= list.get(i).getBoardNo() %></td>
						<td><%= list.get(i).getBoardTitle() %></td>
						<td><%= list.get(i).getNickName() %></td>
						<td><%= list.get(i).getBoardDate() %></td>
						<td><%= list.get(i).getBoardHour() %> : <%= list.get(i).getBoardMin() %></td>
						<td><%= list.get(i).getBoardCount() %></td>
					</tr>
					<% } %>
				<% } %>
				</tbody>
			</table>
		</div>
		
		<br>
		
		<div id="move_page" align="center">
			<% if(!m.getUserId().equals(loginUser.getUserId())){ %>
				<button onclick="location.href='<%= request.getContextPath() %>/myProfile.me?userId=<%= m.getUserId() %>&currentPage=1'">&lt;&lt;</button>
				<button id="beforeBtn" onclick="location.href='<%= request.getContextPath() %>/myProfile.me?userId=<%= m.getUserId() %>&currentPage=<%= pi.getCurrentPage() %>-1'">&lt;</button>
				<script>
					if(<%= pi.getCurrentPage() %> <= 1){
						$('#beforeBtn').prop('disabled', true);
					}
				</script>
				<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++){ %>
					<% if(p == pi.getCurrentPage()){ %>
						<button id="choosen" disabled><%= p %></button>
					<% } else { %>
						<button class="numBtn" onclick="location.href='<%= request.getContextPath() %>/myProfile.me?userId=<%= m.getUserId() %>&currentPage=<%= p %>'"><%= p %></button>
					<% } %>
				<% } %>
				
				<button id="afterBtn" onclick="location.href='<%= request.getContextPath() %>/myProfile.me?userId=<%= m.getUserId() %>&currentPage=<%= pi.getCurrentPage() %>+1'">&gt;</button>
				<script>
					if(<%= pi.getCurrentPage() %> >= <%= pi.getMaxPage() %>){
						$('#afterBtn').prop('disabled', true);
					}
				</script>
				<button onclick="location.href='<%= request.getContextPath() %>/myProfile.me?userId=<%= m.getUserId() %>&currentPage=<%= pi.getMaxPage() %>'">&gt;&gt;</button>
			<% } else { %>
			
				<button onclick="location.href='<%= request.getContextPath() %>/myProfile.me?currentPage=1'">&lt;&lt;</button>
				<button id="beforeBtn" onclick="location.href='<%= request.getContextPath() %>/myProfile.me?currentPage=<%= pi.getCurrentPage() %>-1'">&lt;</button>
				<script>
					if(<%= pi.getCurrentPage() %> <= 1){
						$('#beforeBtn').prop('disabled', true);
					}
				</script>
				<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++){ %>
					<% if(p == pi.getCurrentPage()){ %>
						<button id="choosen" disabled><%= p %></button>
					<% } else { %>
						<button class="numBtn" onclick="location.href='<%= request.getContextPath() %>/myProfile.me?currentPage=<%= p %>'"><%= p %></button>
					<% } %>
				<% } %>
				
				<button id="afterBtn" onclick="location.href='<%= request.getContextPath() %>/myProfile.me?currentPage=<%= pi.getCurrentPage() %>+1'">&gt;</button>
				<script>
					if(<%= pi.getCurrentPage() %> >= <%= pi.getMaxPage() %>){
						$('#afterBtn').prop('disabled', true);
					}
				</script>
				<button onclick="location.href='<%= request.getContextPath() %>/myProfile.me?currentPage=<%= pi.getMaxPage() %>'">&gt;&gt;</button>
			<% } %>
		</div>
		<!-- 게시판 -->
		
	</div>
	
	<script>
		$('#subscribed').click(function(){
		<%-- 			location.href="<%= request.getContextPath() %>/unsubscribe.me?subNo=" + $(this).parent().parent().children().children().eq(0).val(); --%>
			$('#subForm').attr('action', 'unsubscribe.me?page=profile');
			$('#subForm').submit();
		});
		
		$('#board_table td').click(function(){
			var bClass = $(this).parent().children().eq(0).val();
			var bNo = $(this).parent().children().eq(1).text();
			
			if(bClass == '1'){
				location.href = '<%= request.getContextPath() %>/detail.re?bNo=' + bNo;
			} else if(bClass == '2'){
				location.href = '<%= request.getContextPath() %>/detail.jo?bNo=' + bNo;
			} else {
				location.href = '<%= request.getContextPath() %>/detail.bu?bNo=' + bNo;
			}
		});
	</script>
</body>
</html>