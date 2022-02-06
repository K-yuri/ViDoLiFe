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
    <title>비밀번호 재설정</title>
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
  		padding: 15px;
  		font-size: 16px;
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
    #mainlogo{
    	width: 280px; weight: 280px;
    }
    #LoginButton{
    	width: 100px; height: 45px;
    	align: right;
    	text-align: center;
    	position: relative;
        left: 1600px;
        bottom: 80px;
    	border: none;
    	border-radius: 5px;
    	color: white;
    	background: #00CED1;
    }
	 
    </style>
  </head>
	<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="left">
  
		<input id="LoginButton" class="btn btn-lg btn-primary btn-block" type="button" value="로그인" onclick="location.href='<%= request.getContextPath() %>/loginform.me'"><br>
   	    <div class="card align-middle" style="width:400px; height: 500px; background: #F8F8FF; border: 0;">
		<div class="card-title" style="margin-top:20px;">
            
			<h2 class="card-title" style="color:red;"><img id="mainlogo" src="images/logo.png"/></h2>
		</div>
      <form action="<%= request.getContextPath() %>/updateSearchPwd.me" method="post" id="updatePwd" name="updatePwd">
		<div class="card-body">
  		<input type="text" name="userId" id="userId" class="form-control" placeholder="아이디" autofocus required><BR>
        <input type="password" name="newPwd" id="newPwd" class="form-control" placeholder="새로운 비밀번호" autofocus required><BR>
        <input type="password" name="newPwd" id="newPwd" class="form-control" placeholder="새로운 비밀번호 확인" autofocus required><BR>
   
         <p id="check" class="check"></p><br/>
        <input id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit" value="변경" onclick="checkPwd()">
      </form>
      <script>
      function checkPwd(){
    	  
			if(document.updatePwd.newPwd.value == 0){
				alert("새로운 비밀번호를 입력해주세요.");
				updatePwd.newPwd.focus();
      			return;
			}
			
		}
      </script>
  </body>
</html>