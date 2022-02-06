<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
 	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
     <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>로그인 폼</title>
    <style>
        @import url("http://fonts.googleapis.com/earlyaccess/nanumgothic.css"); 
	
	html {
		height: 100%;
	}
	
	body {
	    width:100%;
	    height:100%;
	    margin: 0;
  		padding-top: 120px;
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
  		padding: 15px;
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
    #logo{width: 280px; weight: 280px;}
	 
    </style>
</head>

	<body cellpadding="0" cellspacing="0" marginleft="0" margintop="0" width="100%" height="100%" align="center">

	<div class="card align-middle" style="width:25rem;">
		<div class="card-title" style="margin-top:30px;">
            
			<h2 class="card-title" style="color:red;"><img id="logo" src="images/logo.png"/></h2>
		</div>
	<% if(loginUser == null){ %>
      <form class="login" action="<%= request.getContextPath() %>/login.me" method="post">
<!--        <div class="checkbox">
            <label>
            <input type="radio" name="mode" value="admin"> 관리자
			&nbsp;&nbsp;
			<input type="radio" name="mode" value="member" checked> 일반회원
            </label>
          </div> -->  
		<div class="card-body">
  
        <input type="text" name="userId" id="userId" class="form-control" placeholder="아이디" autofocus required><BR>
        <input type="password" name="userPwd" id="userPwd" class="form-control" placeholder="비밀번호"  required><br>
         <p id="check" class="check"></p><br/>
        <input id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit" value="로그인">
      </form>
		</div>
        <div class="links">
            <a id="searchId" onclick="location.href='<%= request.getContextPath() %>/searchId.me'">아이디 찾기</a> | <a id="searchPwd" onclick="location.href='<%= request.getContextPath() %>/searchPwd.me'">비밀번호 찾기</a> | <a id="signUp" onclick="location.href='<%= request.getContextPath() %>/signUpForm.me'">회원가입</a>
        </div>
    <% } else { %>
    	<div id="userInfo" align="right">
    		<label><%= loginUser.getUserName() %>님 환영합니다!</label>
    		<div class="loginBtns">
    			<input type="button" value="로그아웃" onclick="location.href='<%= request.getContextPath() %>/logout.me'">
    		</div>
		</div>
	<% } %>
</body>
</html>