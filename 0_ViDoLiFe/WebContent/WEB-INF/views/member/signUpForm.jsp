<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>회원가입</title>
    <style>
        @import url("http://fonts.googleapis.com/earlyaccess/nanumgothic.css"); 
	
	html {
		height: 100%;
	}
	
	body {
	    width:100%;
	    height:100%;
	    margin: 0;
  		padding-top: 100px;
  		padding-bottom: 40px;
  		font-family: 'Jua', sans-serif;
  		background-repeat: no-repeat;
  		background : #F8F8FF;
	}
	
    .card {
        margin: 0 auto; /* Added */
        float: none; /* Added */
        margin-bottom: 10px; /* Added */
        background : #F8F8FF;
        border : 0;
	}

    #btn-Yes{
        background-color: #00CED1;
        border: none;
    }
	
	.login .form-control {
  		position: relative;
  		height: auto;
		-webkit-box-sizing: border-box;
     	-moz-box-sizing: border-box;
        	 box-sizing: border-box; 
  		padding: 10px;
  		font-size: 16px;
	}
    .checkbox{
        margin-right: 20px;
        text-align: right;
    }
    .card-title{
        margin-left: 30px;
    }

    .links{
        text-align: center;
        margin-bottom: 10px;
    }
    a{ 
    	color: #00CED1; text-decoration: none; 
    }
    .check{
    	color : red;
    }
    #mainlogo{width: 280px; weight: 280px;}
    #idCheck {
    	position: relative;
    	top: 35px;
    	left: 370px;
		border: none;
		border-radius: 7px;
		background: #00CED1;
		vertical-align: middle;
		font-family: 'Jua', sans-serif;
		color: white;
		width: 90px;
		height: 40px;
	}
	#same{
		position: relative;
    	bottom: 30px;
    	left: 360px;
	}
	 
    </style>
</head>
	<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

	<div class="card align-middle" style="width:25rem;">
		<div class="card-title" style="margin-top:30px;">
			<h2 class="card-title" style="color:red;"><img id="mainlogo" src="images/logo.png"/></h2>
		</div>
      <form action="<%= request.getContextPath() %>/insert.me" method="post" id="joinForm" name="joinForm">
<!--        <div class="checkbox">
            <label>
            <input type="radio" name="mode" value="admin"> 관리자
			&nbsp;&nbsp;
			<input type="radio" name="mode" value="member" checked> 일반회원
            </label>
          </div> -->  
		<div class="card-body"> 
  		<button id="idCheck">중복확인</button>
        <input type="text" name="LoginId" id="Id" class="form-control" placeholder="아이디" autofocus required><br>
        <input type="password" name="LoginPwd" id="Pw1" onchange="isSame()" class="form-control" placeholder="비밀번호"  required><br>
        <input type="password" name="LoginPwd2" id="Pw2" onchange="isSame()" class="form-control" placeholder="비밀번호 확인"  required>&nbsp;&nbsp;<span id="same"></span><br>
        <input type="text" name="LoginName" id="Pw3" class="form-control" placeholder="이름"  required><br>
        <input type="text" name="LoginNick" id="Pw4" class="form-control" placeholder="닉네임"  required><br>
        <input type="text" name="LoginEmail" id="Pw5" class="form-control" placeholder="이메일"  required><br>
      
         <p id="check" class="check"></p><br/>
        <input id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit" value="회원가입" onclick="infoConfirm()">
      </form>
      <script type="text/javascript">
      	document.getElementById('idCheck').onclick = function(){      		
      		window.open('checkIdForm.me', 'idCheckForm', 'width=400, height=300, left=750, top=350');
      	}
      	function isSame() {
      	    var pw = document.joinForm.LoginPwd.value;
      	    var conPw = document.joinForm.LoginPwd2.value;
      	    var regExp = /^(?=.*[a-z0-9])(?=.*[!@#$%^&*]).{4,20}$/;
      	    
      	    if (!regExp.test(Pw1)) {
      	        window.alert('비밀번호는 4글자 이상, 20글자 이하, 특수문자가 포함되어야 사용 가능합니다.');
//      	        document.getElementById('Pw1').value = document.getElementById('Pw2').value;
//      	        document.getElementById('same').innerHTML='';
      	    }
      	    if(document.getElementById('Pw1').value!='' && document.getElementById('Pw2').value!='') {
      	        if(document.getElementById('Pw1').value == document.getElementById('Pw2').value) {
      	            document.getElementById('same').innerHTML='비밀번호가 일치합니다.';
      	            document.getElementById('same').style.color='blue';
      	        }
      	        else {
      	            document.getElementById('same').innerHTML='비밀번호가 일치하지 않습니다.';
      	            document.getElementById('same').style.color='red';
      	        }
      	    }
      	}
      	
      	function infoConfirm(){
      		if(document.joinForm.LoginId.value.length == 0){
      			alert("아이디를 입력해 주세요.");
      			joinForm.LoginId.focus();
      			return;
      		}
      		
      		if(document.joinForm.LoginPwd.value == 0){
      			alert("비밀번호를 입력해 주세요.");
      			joinForm.LoginPwd.focus();
      			return;
      		}
    
      		if(document.joinForm.LoginPwd.value != document.joinForm.LoginPwd2.value){
      			alert("비밀번호가 일치하지 않습니다.");
      			joinForm.LoginPwd2.focus();
      			return;
      		}
      		
      		if(document.joinForm.LoginName.value.length == 0){
      			alert("이름을 입력해 주세요.");
      			joinForm.LoginName.focus();
      			return;
      		}
      		
      		if(document.joinForm.LoginNick.value.length == 0){
      			alert("닉네임을 입력해 주세요.");
      			joinForm.LoginNick.focus();
      			return;
      		}
      		
      		if(document.joinForm.LoginEmail.value.length == 0){
      			alert("이메일을 입력해 주세요.");
      			joinForm.LoginEmail.focus();
      			return;
      		}
      		
      		alert("성공적으로 가입되었습니다. 환영합니다!");
      	}

      </script>
   
  </body>
</html>