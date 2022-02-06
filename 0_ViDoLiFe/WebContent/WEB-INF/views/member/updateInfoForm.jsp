<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
	Member m = (Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 보기</title>
<style>
	#infoTitle{text-align: center; margin-top: 30px;}
	
	table{margin-left: auto; margin-right: auto; width: 630px;}
	table th{text-align: center; height: 60px; border-bottom: 1px solid lightgray;}
	table td{border-bottom: 1px solid lightgray; padding-left: 70px;}
	.btnArea{padding-left: 0px; text-align: center;}
	
	.imgArea{width: 150px; height: 110px;}
	#profileImg{width: 90px; height: 90px; border-radius: 45px;}
	
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
	<form action="<%= request.getContextPath() %>/update.me" method="post" encType="multipart/form-data">
		<table>
			<tr>
				<th class="imgArea">프로필 사진</th>
				<td colspan="2">
					<img src= "<%= m.getUserPicPath() %>" id="profileImg">
					<input type="button" class="btn" id="imgBtn" value="사진 선택">
					<input type="file" id="selectImg" name="selectImg" onchange="LoadImg(this)"> &nbsp;
					<input type="button" class="btn" id="deleteImgBtn" value="삭제">
				</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="myId" value="<%= m.getUserId() %>" size="40" class="noUpdate" readonly>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="myName" value="<%= m.getUserName() %>" size="40" class="noUpdate" readonly>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="email" name="myEmail" value="<%= m.getUserEmail() %>" size="40" class="noUpdate" readonly>
				</td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>
					<input type="text" name="myNickName" value="<%= m.getUserNick() %>" size="40">
				</td>
			</tr>
			<tr>
				<th>프로필 문구</th>
				<td>
					<textarea cols="44" rows="3" name="myProfileMsg" style="resize: none;"><%= m.getUserProfileMsg() == null ? "" : m.getUserProfileMsg() %></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: none;" class="btnArea">
					<br>
					<input type="submit" class="btn" value="저장하기"> &nbsp;
					<input type="button" class="btn" onclick="location.href='javascript:history.go(-1);'" value="취소">
				</td>
			</tr>
		</table>
		
		<script>
		$(function(){
			$('#selectImg').hide();
			
			$('#imgBtn').click(function(){
				$('#selectImg').click();
			});
		});
		
		function LoadImg(value) {
			if(value.files && value.files[0]) {
				var reader = new FileReader();
				
				reader.onload = function(e){
					$('#profileImg').attr("src", e.target.result);
				}
			}
			
			reader.readAsDataURL(value.files[0]);
		}
		
		$('#deleteImgBtn').click(function(){
			$('#selectImg').val("");
			$('#profileImg').attr("src", "images/profile.png");
			
		});
	</script>
	</form>
	<br><br>
	
</body>
</html>