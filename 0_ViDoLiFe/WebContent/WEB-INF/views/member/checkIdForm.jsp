<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인</title>
<style>
	#check {
		border: none;
		border-radius: 4px;
		background: #00CED1;
		vertical-align: middle;
		font-family: 'Jua', sans-serif;
		height: 30px;
		color: white;
	}
	#usedId {
		border: none;
		border-radius: 4px;
		background: #00CED1;
		vertical-align: middle;
		font-family: 'Jua', sans-serif;
		height: 30px;
		color: white;
	}
	#cancel {
		border: none;
		border-radius: 4px;
		background: #00CED1;
		vertical-align: middle;
		font-family: 'Jua', sans-serif;
		height: 30px;
		color: white;
	}
	#inputId {
		border: 1px solid #00CED1;
		font-size: 15px;
		width: 300px;
		height: 30px;
	}
</style>
</head>
<body onload="inputValue();">
	<b>아이디 중복 검사</b>
	<br>
	<form action="<%= request.getContextPath() %>/checkId.me" id="idCheckForm">
		<input type="text" id="inputId" name="inputId">
		<input type="submit" id="check" value="중복확인"/>
	</form>
	
	<br>
	
	<%
	Integer result = (Integer)request.getAttribute("result");
	if(result != null){
		if(result > 0){
	%>
		이미 사용 중인 아이디 입니다.
	<% } else { %>
		사용 가능한 아이디입니다.
	<%   } %>
	<%} %>
	
	<br>
	<br>
	
	<input type="button" id="usedId" value="확인" onclick="window.close();">
	<input type="button" id="cancel" value="취소" onclick="window.close();">
	
	<script>
		function inputValue(){
			if(<%= result %> == null){
				document.getElementById('inputId').value = opener.document.joinForm.LoginId.value;
			} else {
				document.getElementById('inputId').value = '<%= request.getAttribute("checkedId") %>';
			}
		}
		
		document.getElementById('userId').onclick = function(){
			opener.document.joinForm.LoginId.value = document.getElementById('inputId').value;
			self.close();
		}
	</script>
</body>
</html>