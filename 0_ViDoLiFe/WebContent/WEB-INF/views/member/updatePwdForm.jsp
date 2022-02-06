<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
	Member m = (Member)request.getAttribute("myInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 보기</title>
<style>
	#infoTitle{text-align: center; margin-top: 30px;}
	
	table{margin-left: auto; margin-right: auto; width: 630px;}
	table th{text-align: center; height: 80px; border-bottom: 1px solid lightgray;}
	table td{border-bottom: 1px solid lightgray;}
	
	.photoTh{width: 150px; height: 110px;}
	#profilePhoto{width: 90px; height: 90px; border-radius: 45px;}
	
	.btn{
		background: #00CED1;
		border: none;
		font-family: 'Jua', sans-serif;
		height: 25px;
		border-radius: 5px;
		cursor: pointer;
	}
	
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<h2 id="infoTitle">비밀번호 변경하기</h2>
	<form action="<%= request.getContextPath() %>/updatePwd.me" method="post" onsubmit="return checkPwd();">
		<table>
			<tr>
				<th>현재 비밀번호</th>
				<td colspan="2" style="padding-left: 70px;">
					<input type="password" size="25" name="userPwd">
				</td>
			</tr>
			<tr>
				<th rowspan="2">새로운 비밀번호</th>
				<td style="border-bottom: none; padding-left: 70px;">
					<input type="password" size="25" name="newPwd1" id="newPwd1">
				</td>
				<td style="border-bottom: none;"><span id="pwd1Result"></span></td>
			</tr>
			<tr>
				<td colspan="2" style="padding-left: 70px; font-size: 90%;">4~20 글자의 비밀번호를 입력해주세요 (!,@,#,$,%,^,&,* 중 1개 반드시 포함)</td>
				</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td colspan="2" style="padding-left: 70px;">
					<input type="password" size="25" name="newPwd2">
				</td>
				
			</tr>
			<tr>
				<td colspan="3" align="center" style="border-bottom: none;" class="btnTd">
					<br>
					<input type="submit" class="btn" value="변경하기"> &nbsp;
					<input type="button" class="btn" value="취소" onclick="location.href='javascript:history.go(-1);'">
				</td>
			</tr>
		</table>
	</form>
	
	<br>
	
	<script>
		var regExp = /^(?=.*[a-z0-9])(?=.*[!@#$%^&*]).{4,20}$/;
		var check1 = false;
		var check2 = false;
	
		$('#newPwd1').keyup(function(){
			var confirmPwd = regExp.test($(this).val());
			
			if($(this).val() == '' || $(this).val().length == 0){
				$('#pwd1Result').text('');
			} else if(confirmPwd){
				$('#pwd1Result').text('사용 가능한 비밀번호입니다.').css('color', 'green');
				check1 = true;
			} else {
				$('#pwd1Result').text('사용 불가능한 비밀번호입니다.').css('color', 'red');
				check1 = false;
			}
			
		});
	
		function checkPwd() {
			var newPwd1 = document.getElementsByName('newPwd1');
			var newPwd2 = document.getElementsByName('newPwd2');
			
			if(newPwd1[0].value == newPwd2[0].value) {
				check2 = true;
			} else {
				alert('비밀번호가 일치하지 않습니다. 다시 입력해주세요');
				newPwd2[0].focus();
				check2 = false;
			}
			
			console.log(check1);
			console.log(check2);
			
			if(check1 && check2){
				return true;
			} else {
				return false;
			}
		}
	</script>
</body>
</html>