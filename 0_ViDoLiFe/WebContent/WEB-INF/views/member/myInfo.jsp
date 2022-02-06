<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
	Member m = (Member)request.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 보기</title>
<style>
	#infoTitle{text-align: center; margin-top: 30px;}
	
	table{margin-left: auto; margin-right: auto; width: 600px; text-align: center;}
	table th{border-bottom: 1px solid lightgray; height: 60px;}
	table td{border-bottom: 1px solid lightgray; padding-right: 60px;}
	
	
	.photoTh{width: 150px; height: 110px;}
	.profilePhoto{width: 90px; height: 90px; border-radius: 45px;}
	
	.noUpdate{background: lightgray;}
	
	.btn{
		background: #00CED1;
		border: none;
		font-family: 'Jua', sans-serif;
		height: 25px;
		border-radius: 5px;
		cursor: pointer;
	}
	
	#deleteBtn{background: #DB6A76;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<h2 id="infoTitle">나의 회원 정보</h2>
	<form action="<%= request.getContextPath() %>/updateForm.me" method="post">
		<table>
			<tr>
				<th class="photoTh">프로필 사진</th>
				<td colspan="2">
					<% if(m.getUserPicNew() == null){ %>
						<img src="images/profile.png" class="profilePhoto" id="basicImg">
						<input type="hidden" name="profileImg" value="images/profile.png">
					<% } else { %>
						<img src="<%= request.getContextPath() %>/uploadFiles/<%= m.getUserPicNew() %>" class="profilePhoto" id="selectedImg">
						<input type="hidden" name="profileImg" value="uploadFiles/<%= m.getUserPicNew() %>">
					<% } %>
				</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>
					<%= m.getUserId() %>
					<input type="hidden" name="myId" value="<%= m.getUserId() %>" size="40" class="noUpdate" readonly>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<%= m.getUserName() %>
					<input type="hidden" name="myName" value="<%= m.getUserName() %>" size="40" class="noUpdate" readonly>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<%= m.getUserEmail() %>
					<input type="hidden" name="myEmail" value="<%= m.getUserEmail() %>" size="40" class="noUpdate" readonly>
				</td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>
					<%= m.getUserNick() %>
					<input type="hidden" name="myNickName" value="<%= m.getUserNick() %>" size="40">
				</td>
			</tr>
			<tr>
				<th>프로필 문구</th>
				<td>
					<%= m.getUserProfileMsg() == null ? "" : m.getUserProfileMsg() %>
					<textarea cols="44" rows="3" name="myProfileMsg" style="resize: none; display: none;" readonly><%= m.getUserProfileMsg() == null ? "" : m.getUserProfileMsg() %></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" style="border-bottom: none; padding-right: 0px;">
					<br>
					<input type="submit" id="updateBtn" class="btn" value="수정하기"> &nbsp;
					<input type="button" id="updatePwdBtn" class="btn" value="비밀번호 변경하기" onclick="location.href='<%= request.getContextPath() %>/updatePwdForm.me'"> &nbsp;
					<input type="button" id="deleteBtn" class="btn" value="탈퇴하기" onclick="deleteMem();"> &nbsp;
					<input type="button" id="backBtn" class="btn" value="이전 페이지" onclick="loaction.href=history.back()"> &nbsp;
					
				</td>
			</tr>
		</table>
	</form>
	
	<br>
	
	<script>
		function deleteMem() {
			var bool = confirm("정말 탈퇴하시겠습니까?");
			
			if(bool) {
				location.href="<%= request.getContextPath() %>/delete.me";
			}
		}
	</script>
</body>
</html>