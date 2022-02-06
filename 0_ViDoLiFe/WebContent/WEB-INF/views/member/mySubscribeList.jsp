<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, member.model.vo.Subscribe" %>
<% 
	Member m = (Member)request.getAttribute("member");
	ArrayList<Subscribe> list = (ArrayList<Subscribe>)request.getAttribute("list");
	ArrayList<Subscribe> loginList = (ArrayList<Subscribe>)request.getAttribute("loginList");
	boolean check = false;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
		font-size: 130%;
		line-height: 20px;
	}
	
	#profileMessage{min-height: 50px;}
	
	#table_subscribe{width: 100%;}
	
	#toProfileBtn{float: left; background: #AFEEEE;}
	
	#table_subscribe span{
		position: relative; top: -20px;
	}
	
	.btn{
		float: right;
		background: #00CED1;
		border: none;
		font-family: 'Jua', sans-serif;
		height: 25px;
		border-radius: 5px;
		cursor: pointer;
	}
	
	.subscribing{background: #00CED1;}
	.subscribed{background: lightgray;}
	
	.subscribePhoto{width: 60px; height: 60px; border-radius: 30px;}
</style>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div id="outer">
		<% if(m.getUserPicNew() == null) { %>
			<img src="images/profile.png" class="profilePhoto">
		<% } else { %>
			<img src="<%= request.getContextPath() %>/uploadFiles/<%= m.getUserPicNew() %>" class="profilePhoto">
		<% } %>
		<div id="inner">
			<br>
			<span id="nickname"><%= m.getUserNick() %></span><br>
			<span id="subscribeList" style="color: #00CED1">구독 회원</span><br>
			<span id="profileMessage"><%= m.getUserProfileMsg() == null ? "&nbsp;" : m.getUserProfileMsg() %></span>
		</div>
		
		<br><br><br><br>
		
		<table id="table_subscribe">
			<tr>
				<td colspan="2"><input type="button" class="btn" id="toProfileBtn" value="&lt;&lt; 글 보러가기" onclick="javascript:history.back()"><br><br></td>
			</tr>
			<% if(list.isEmpty()) { %>
			<tr>
				<td colspan="2">구독한 회원이 없습니다.</td>
			</tr>
			<% } else { %>
				<% for(int i = 0; i < list.size(); i++) { %>
					<tr>
						<td>
<%-- 							<input type="hidden" name="subNo" value="<%= list.get(i).getSubNo() %>"> --%>
							<input type="hidden" name="userId" value="<%= list.get(i).getToUser() %>">
							<% if(list.get(i).getToUserPicNew() == null) { %>
								<img class="subscribePhoto" src="images/profile.png">
							<% } else { %>
								<img class="subscribePhoto" src="<%= request.getContextPath() %>/uploadFiles/<%= list.get(i).getToUserPicNew() %>">
							<% } %>
							&nbsp;&nbsp; <span><%= list.get(i).getToUserNick() %></span>
						</td>
						<td>
							<% if(loginList == null) { %>
								<input type="button" class="btn subscribed" value="&nbsp;구독 중&nbsp">
							<% } else { %>
								<% if(!list.get(i).getToUser().equals(loginUser.getUserId())) { %>
									<% check = false; %>
									<% for(int j = 0; j < loginList.size(); j++){ %>
										<% if(list.get(i).getToUser().equals(loginList.get(j).getToUser())){ %>
											<% check = true; %>
										<% } %>
									<% } %>
									
									<% if(check){ %>
										<input type="button" class="btn subscribed" value="&nbsp;구독 중&nbsp;">
									<% } else { %>
										<input type="button" class="btn subscribing" value="구독하기">
									<% } %>
								<% } %>
							<% } %>
						</td>
					</tr>
				<% } %>
			<% } %>
		</table>
	</div>
	<br>
	
	<script>
		$('.subscribePhoto').click(function(){
			location.href="<%= request.getContextPath() %>/myProfile.me?userId=" + $(this).parent().children().eq(0).val();
		})
	
		$('.subscribed').click(function(){
			location.href="<%= request.getContextPath() %>/unsubscribe.me?fromUser=" + "<%= loginUser.getUserId() %>" + "&toUser=" + $(this).parent().parent().children().children().eq(0).val() + "&pageUser=" + "<%= m.getUserId() %>";
		});
		
		$('.subscribing').click(function(){
			location.href="<%= request.getContextPath() %>/subscribe.me?fromUser=" + "<%= loginUser.getUserId() %>" + "&toUser=" + $(this).parent().parent().children().children().eq(0).val() + "&pageUser=" + "<%= m.getUserId() %>";
		});
		
		
		
		
	</script>
</body>
</html>