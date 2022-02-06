<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, board.model.vo.*, board.model.service.*" %>
<%
	BoardService bService = new BoardService();
	ArrayList<Board> list = bService.selectBestList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="reco_table" id="main_table">
		<thead>
			<tr>
				<th class="post_num"><span>글번호</span></th>
				<th class="post_title">제목</th>
				<th class="post_writer">작성자</th>
				<th class="post_date">작성일</th>
				<th class="post_time">시각</th>
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
</body>
</html>