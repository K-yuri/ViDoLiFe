/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.54
 * Generated at: 2021-11-25 06:19:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import board.model.vo.Board;
import board.model.vo.Comment;
import java.util.ArrayList;
import member.model.vo.Member;

public final class boardJoinDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/board/../common/menubar.jsp", Long.valueOf(1637821093804L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
    _jspx_imports_classes.add("board.model.vo.Comment");
    _jspx_imports_classes.add("board.model.vo.Board");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	Board b = (Board)request.getAttribute("board");
	ArrayList<Comment> list = (ArrayList<Comment>)request.getAttribute("list");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Jua&family=Nanum+Gothic&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("	body{\r\n");
      out.write("		background: ghostwhite;\r\n");
      out.write("		margin-left: 10%;\r\n");
      out.write("		margin-right: 10%;\r\n");
      out.write("		font-family: 'Jua', sans-serif;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	header{\r\n");
      out.write("		font-family: 'Jua', sans-serif;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#logo {width: 200px;}\r\n");
      out.write("	#login {text-align: right; font-size: 8px;}\r\n");
      out.write("	\r\n");
      out.write("	#searchText {\r\n");
      out.write("		text-align: right;\r\n");
      out.write("		margin-top: 10px;\r\n");
      out.write("		margin-bottom: 10px;\r\n");
      out.write("		padding: 0px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#searchWord {\r\n");
      out.write("		border: 1px solid #00CED1;\r\n");
      out.write("		font-size: 15px;\r\n");
      out.write("		width: 300px;\r\n");
      out.write("		height: 30px;\r\n");
      out.write("	}\r\n");
      out.write("	#input {\r\n");
      out.write("		border: none;\r\n");
      out.write("		background: #00CED1;\r\n");
      out.write("		vertical-align: middle;\r\n");
      out.write("		font-family: 'Jua', sans-serif;\r\n");
      out.write("		width: 50px;\r\n");
      out.write("		height: 35px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#topMenu {\r\n");
      out.write("		height: 30px;\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		margin: 0px;\r\n");
      out.write("		padding: 0px;\r\n");
      out.write("	}\r\n");
      out.write("	#topMenu ul {\r\n");
      out.write("		margin: 0px;\r\n");
      out.write("		padding: 0px;\r\n");
      out.write("	}\r\n");
      out.write("	#topMenu ul li {\r\n");
      out.write("		list-style: none;\r\n");
      out.write("		color: white;\r\n");
      out.write("		float: left;\r\n");
      out.write("		line-height: 30px;\r\n");
      out.write("		vertical-align: middle;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("	}\r\n");
      out.write("	#topMenu .menuLink {\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("		color: black;\r\n");
      out.write("		display: block;\r\n");
      out.write("		font-size: 15px;\r\n");
      out.write("		font-weight: bold;\r\n");
      out.write("	}\r\n");
      out.write("	#topMenu ul li:hover {background-color: ghostwhite;}\r\n");
      out.write("	\r\n");
      out.write("	#search {background: #AFEEEE; width: 20%;}\r\n");
      out.write("	#review {background: #7FFFD4; width: 20%;}\r\n");
      out.write("	#allview {background: #40E0D0; width: 20%;}\r\n");
      out.write("	#allbuy {background: #48D1CC; width: 20%;}\r\n");
      out.write("	#mypage {background: #00CED1; width: 20%;}\r\n");
      out.write("	\r\n");
      out.write("	.contents{\r\n");
      out.write("		margin-top:10px;\r\n");
      out.write("		border: 1px solid lightgray;\r\n");
      out.write("		padding: 20px;\r\n");
      out.write("	}\r\n");
      out.write("	.board_titleArea{\r\n");
      out.write("		text-align:left;\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	a{\r\n");
      out.write("		color: black;\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.content_part{\r\n");
      out.write("		border-bottom: 1px solid lightgray;\r\n");
      out.write("		padding-bottom: 10px;\r\n");
      out.write("		font-family: 'Nanum Gothic', sans-serif;\r\n");
      out.write("		line-height: 150%;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.content_titleArea, .comment_partArea{\r\n");
      out.write("		border-bottom: 1px solid lightgray;\r\n");
      out.write("		padding-bottom: 10px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.comment_titleArea{\r\n");
      out.write("		padding-bottom: 20px;\r\n");
      out.write("		font-size: 20px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#return_list{\r\n");
      out.write("		border: none;\r\n");
      out.write("		background: #00CED1;\r\n");
      out.write("		font-family: 'Jua', sans-serif;\r\n");
      out.write("		height: 25px;\r\n");
      out.write("		border-radius: 5px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.btn{\r\n");
      out.write("		border: none;\r\n");
      out.write("		background: #00CED1;\r\n");
      out.write("		font-family: 'Jua', sans-serif;\r\n");
      out.write("		height: 25px;\r\n");
      out.write("		width: 50px;\r\n");
      out.write("		border-radius: 5px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#replySelectTable{\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		margin: 5px;\r\n");
      out.write("		padding: 5px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#replySelectTable td{\r\n");
      out.write("		border-bottom: 1px solid lightgray;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#replyWriterTable{\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		margin: 5px;\r\n");
      out.write("		padding: 5px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#addReply{\r\n");
      out.write("		border: none;\r\n");
      out.write("		background: #00CED1;\r\n");
      out.write("		font-family: 'Jua', sans-serif;\r\n");
      out.write("		height: 50px;\r\n");
      out.write("		width: 50px;\r\n");
      out.write("		border-radius: 5px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	button:hover{cursor: pointer;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      out.write('\r');
      out.write('\n');

	Member loginUser = (Member)session.getAttribute("loginUser");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script src=\"js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Jua&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<style>\r\n");
      out.write("	body{\r\n");
      out.write("		height: 100%;\r\n");
      out.write("		background: ghostwhite;\r\n");
      out.write("		margin-left: 10%;\r\n");
      out.write("		margin-right: 10%;\r\n");
      out.write("		font-family: 'Jua', sans-serif;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	header{\r\n");
      out.write("		font-family: 'Jua', sans-serif;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	#wrap-all{\r\n");
      out.write("		min-height: 100%;\r\n");
      out.write("		position: relative;\r\n");
      out.write("	}\r\n");
      out.write("	#wrap{\r\n");
      out.write("		padding-bottom: 100%;\r\n");
      out.write("		height: 100%;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#logo {width: 200px;}\r\n");
      out.write("	#login {text-align: right; font-size: 15px; cursor: pointer;}\r\n");
      out.write("	\r\n");
      out.write("	#searchText {\r\n");
      out.write("		text-align: right;\r\n");
      out.write("		margin-top: 10px;\r\n");
      out.write("		margin-bottom: 10px;\r\n");
      out.write("		padding: 0px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#searchWord {\r\n");
      out.write("		border: 1px solid #00CED1;\r\n");
      out.write("		font-size: 15px;\r\n");
      out.write("		width: 300px;\r\n");
      out.write("		height: 30px;\r\n");
      out.write("	}\r\n");
      out.write("	#input {\r\n");
      out.write("		border: none;\r\n");
      out.write("		background: #00CED1;\r\n");
      out.write("		vertical-align: middle;\r\n");
      out.write("		font-family: 'Jua', sans-serif;\r\n");
      out.write("		width: 50px;\r\n");
      out.write("		height: 35px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#topMenu {\r\n");
      out.write("		height: 30px;\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		margin: 0px;\r\n");
      out.write("		padding: 0px;\r\n");
      out.write("	}\r\n");
      out.write("	#topMenu ul {\r\n");
      out.write("		margin: 0px;\r\n");
      out.write("		padding: 0px;\r\n");
      out.write("	}\r\n");
      out.write("	#topMenu ul li {\r\n");
      out.write("		list-style: none;\r\n");
      out.write("		color: white;\r\n");
      out.write("		float: left;\r\n");
      out.write("		line-height: 30px;\r\n");
      out.write("		vertical-align: middle;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("	}\r\n");
      out.write("	#topMenu .menuLink {\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("		color: black;\r\n");
      out.write("		display: block;\r\n");
      out.write("		font-size: 15px;\r\n");
      out.write("		font-weight: bold;\r\n");
      out.write("	}\r\n");
      out.write("	#topMenu ul li:hover {background-color: ghostwhite;}\r\n");
      out.write("	\r\n");
      out.write("	#search {background: #AFEEEE; width: 20%;}\r\n");
      out.write("	#review {background: #7FFFD4; width: 20%;}\r\n");
      out.write("	#allview {background: #40E0D0; width: 20%;}\r\n");
      out.write("	#allbuy {background: #48D1CC; width: 20%;}\r\n");
      out.write("	#mypage {background: #00CED1; width: 20%;}\r\n");
      out.write("	\r\n");
      out.write("	#sub {\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("		padding: 5px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#left {\r\n");
      out.write("		width: 50%;\r\n");
      out.write("		float: left;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#right {\r\n");
      out.write("		width: 50%;\r\n");
      out.write("		float: right;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.dropdown{\r\n");
      out.write("		position: relative;\r\n");
      out.write("		display: inline-block;\r\n");
      out.write(" 		float: right;\r\n");
      out.write(" 		margin-top: 5px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.dropdownContent{\r\n");
      out.write("		display: none;\r\n");
      out.write("		position: absolute;\r\n");
      out.write("		z-index: 1;\r\n");
      out.write("		background-color: #F8F8FF;\r\n");
      out.write("		border-radius: 5px;\r\n");
      out.write("		box-shadow: 0px 0px 15px 1px #D8D8D8;\r\n");
      out.write("		margin-top: 3px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#profileContent{\r\n");
      out.write("		width: 140px;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("		right: -47px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#profileIcon{width: 40px; height: 40px; border-radius: 20px; cursor: pointer; margin-left: 20px;}\r\n");
      out.write("	\r\n");
      out.write("	#profileContent span{\r\n");
      out.write("		display: block;\r\n");
      out.write("		line-height: 50px;\r\n");
      out.write("		text-decoration: none;\r\n");
      out.write("		color: black;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#profileContent span:hover{color: #00CED1; cursor: pointer;}\r\n");
      out.write("	\r\n");
      out.write("	#notiIcon{\r\n");
      out.write("		width: 40px; height: 40px; border-radius: 20px;\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#notiContent{\r\n");
      out.write("		width: 230px; height: 300px;\r\n");
      out.write("		right: -85px;\r\n");
      out.write("		padding: 10px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write(" 	#notiContent td{\r\n");
      out.write(" 		padding: 5px;\r\n");
      out.write(" 	}\r\n");
      out.write("	\r\n");
      out.write("	.dot{\r\n");
      out.write("		width: 10px; height: 10px; border-radius: 5px;\r\n");
      out.write("		background: tomato;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.listDot{display: inline-block;}\r\n");
      out.write("	\r\n");
      out.write("	#notiDot{\r\n");
      out.write("		position: absolute; right: -2px; top: 30px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.xBtn{\r\n");
      out.write(" 		background: #AFEEEE;\r\n");
      out.write("		border: none;\r\n");
      out.write("		color: gray;\r\n");
      out.write("		border-radius: 5px;\r\n");
      out.write("		cursor: pointer;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<header>\r\n");
      out.write("		");
      out.write("\r\n");
      out.write("<!-- 	<div id=\"login\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/loginform.me'\" role=\"button\">회원가입/로그인</div> -->\r\n");
      out.write(" 		\r\n");
      out.write(" 		");
      out.write("\r\n");
      out.write(" 		");
 if(loginUser != null){ 
      out.write("\r\n");
      out.write("\r\n");
      out.write("		<div class=\"dropdown\" id=\"profileDropdown\">\r\n");
      out.write("			<img src=\"images/propile.png\" id=\"profileIcon\" role=\"button\">\r\n");
      out.write("			<div class=\"dropdownContent\" id=\"profileContent\">\r\n");
      out.write("				<span onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/myProfile.me'\" role=\"button\">내 프로필</span>\r\n");
      out.write("				<span onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/myInfo.me'\" role=\"button\">내 정보 보기</span>\r\n");
      out.write("				<span onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/logout.me'\">로그아웃</span>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"dropdown\" id=\"notiDropdown\">\r\n");
      out.write("			\r\n");
      out.write("			<img src=\"images/noti.png\" id=\"notiIcon\" role=\"button\">\r\n");
      out.write("			<div class=\"dot\" id=\"notiDot\"></div>\r\n");
      out.write("			<div class=\"dropdownContent\" id=\"notiContent\">\r\n");
      out.write("				<table id=\"notiTable\">\r\n");
      out.write("					<tr>\r\n");
      out.write("					</tr>\r\n");
      out.write("				</table>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		");
 } else { 
      out.write("\r\n");
      out.write("			<div id=\"login\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/loginform.me'\" role=\"button\">회원가입/로그인</div>\r\n");
      out.write("		");
 } 
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("	\r\n");
      out.write("		<div>\r\n");
      out.write("			<a href=\"");
      out.print( request.getContextPath() );
      out.write("\"><img id=\"logo\" src=\"images/logo.png\"></a>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div id=\"searchText\">\r\n");
      out.write("			<input type=\"text\" id=\"searchWord\"><button id=\"input\">검색</button>\r\n");
      out.write("		</div>\r\n");
      out.write("		<nav id=\"topMenu\">\r\n");
      out.write("			<ul>\r\n");
      out.write("				<li id=\"search\"><a class=\"menuLink\" href=\"");
      out.print( request.getContextPath() );
      out.write("/search.ch\">상세검색</a></li>\r\n");
      out.write("				<li id=\"review\"><a class=\"menuLink\" href=\"");
      out.print( request.getContextPath() );
      out.write("/list.re\">리뷰 게시판</a></li>\r\n");
      out.write("				<li id=\"allview\"><a class=\"menuLink\" href=\"");
      out.print( request.getContextPath() );
      out.write("/list.jo\">단체관람 게시판</a></li>\r\n");
      out.write("				<li id=\"allbuy\"><a class=\"menuLink\" href=\"");
      out.print( request.getContextPath() );
      out.write("/list.bu\">공동구매 게시판</a></li>\r\n");
      out.write("				<li id=\"mypage\"><a class=\"menuLink\" href=\"#\">공지사항</a></li>\r\n");
      out.write("			</ul>\r\n");
      out.write("		</nav>\r\n");
      out.write("	</header>\r\n");
      out.write("	\r\n");
      out.write("	<script>		\r\n");
      out.write("		$('.dropdown').click(function(){\r\n");
      out.write("			$(this).children().css('display', 'block');\r\n");
      out.write("		});\r\n");
      out.write("		$('.dropdownContent').mouseleave(function(){\r\n");
      out.write("			$(this).css('display', 'none');\r\n");
      out.write("		});\r\n");
      out.write("		\r\n");
      out.write("		");
      out.write("\r\n");
      out.write("		$('#notiDot').css('visibility', 'hidden');\r\n");
      out.write("		\r\n");
      out.write("		function getNoti(){\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url: 'noti.me',\r\n");
      out.write("				type: 'GET',\r\n");
      out.write("				dataType: 'json',\r\n");
      out.write("				success: function(data){\r\n");
      out.write("					console.log('success');\r\n");
      out.write("					console.log(data.length);\r\n");
      out.write("					\r\n");
      out.write("					var $notiTable = $('#notiTable');\r\n");
      out.write("					\r\n");
      out.write("					if(data.length <= 0){\r\n");
      out.write("						var $tr = $('<tr>');\r\n");
      out.write("						var $dotTd = $('<td>').append(\"<div class='dot listDot'></div>\");\r\n");
      out.write("						var $notiTd = $('<td>').text('새로운 알림이 없습니다.');\r\n");
      out.write("						\r\n");
      out.write("						$tr.append($dotTd);\r\n");
      out.write("						$tr.append($notiTd);\r\n");
      out.write("						\r\n");
      out.write("						$notiTable.append($tr);\r\n");
      out.write("					} else {\r\n");
      out.write("						$('#notiDot').css('visibility', 'visible');\r\n");
      out.write("						\r\n");
      out.write("						for(var i in data){\r\n");
      out.write("							var $tr = $('<tr>');\r\n");
      out.write("							var notiNo = data[i].notiNo;\r\n");
      out.write("							var $xTd = $('<td>').append(\"<input type='button' class='xBtn' value='x' onclick='check(\" + notiNo + \");'>\")\r\n");
      out.write("							\r\n");
      out.write("							if(data[i].notiType == 'BOARD'){\r\n");
      out.write("								var $notiTd = $('<td>').text(data[i].notiFromUserNick + \" 님이 새로운 글 [\" + data[i].boardTitle + \"]을 작성하였습니다.\");\r\n");
      out.write("							} else {\r\n");
      out.write("								var $notiTd = $('<td>').text(data[i].notiFromUserNick + \" 님이 내 글 [\" + data[i].boardTitle + \"]에 새로운 댓글을 작성하였습니다.\");\r\n");
      out.write("							}\r\n");
      out.write("							\r\n");
      out.write("							$tr.append($notiTd);\r\n");
      out.write("							$tr.append($xTd);\r\n");
      out.write("							\r\n");
      out.write("							$notiTable.append($tr);\r\n");
      out.write("						}\r\n");
      out.write("					\r\n");
      out.write("					}\r\n");
      out.write("					\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		");
 if(loginUser != null) { 
      out.write("\r\n");
      out.write("			getNoti();\r\n");
      out.write("		");
 } 
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		function check(value){\r\n");
      out.write("			var notiNo = value;\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url: 'checkNoti.me',\r\n");
      out.write("				data: {notiNo:notiNo},\r\n");
      out.write("				success: function(data){\r\n");
      out.write("					console.log('success');\r\n");
      out.write("					\r\n");
      out.write("					var $notiTable = $('#notiTable');\r\n");
      out.write("					$notiTable.html('');\r\n");
      out.write("					getNoti();\r\n");
      out.write("				}\r\n");
      out.write("// 				error: function(data){\r\n");
      out.write("// 					console.log('fail');\r\n");
      out.write("// 				}\r\n");
      out.write("			});\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<div class=\"contents\">\r\n");
      out.write("		<div class=\"board_titleArea\">\r\n");
      out.write("			<a href=\"");
      out.print( request.getContextPath() );
      out.write("/list.jo\">단체관람 게시판▷</a>\r\n");
      out.write("		</div>\r\n");
      out.write("		<form action=\"");
      out.print( request.getContextPath() );
      out.write("/updateJoinForm.jo\" id=\"detailForm\" method=\"post\">\r\n");
      out.write("		<div class=\"content_titleArea\">\r\n");
      out.write("			<!-- 글제목, 사용자프로필, 글작성 날짜 및 시간, 조회수가 들어가는 부분 -->\r\n");
      out.write("			<div class=\"content_title\" style=\"font-size: 20px;\">\r\n");
      out.write("				");
      out.print( b.getBoardTitle() );
      out.write("\r\n");
      out.write("				<input type=\"hidden\" name=\"title\" value=\"");
      out.print( b.getBoardTitle() );
      out.write("\">\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("			<br>\r\n");
      out.write("			\r\n");
      out.write("			<span class=\"writer_profile\"><a href=\"#\"><img src=\".\\images\\propile.png\" width=\"30\" height=\"30\"></a></span>\r\n");
      out.write("			\r\n");
      out.write("			<span class=\"content_info\">\r\n");
      out.write("				<span class=\"nickname\">\r\n");
      out.write("					<a href=\"#\">");
      out.print( b.getNickName() );
      out.write("</a>\r\n");
      out.write("					<input type=\"hidden\" name=\"writer\" value=\"");
      out.print( b.getNickName() );
      out.write("\">\r\n");
      out.write("				</span>\r\n");
      out.write("			<br>\r\n");
      out.write("			\r\n");
      out.write("			<span class=\"write_date\">");
      out.print( b.getBoardDate() );
      out.write("</span>\r\n");
      out.write("			<span class=\"write_time\">");
      out.print( b.getBoardHour() );
      out.write(' ');
      out.write(':');
      out.write(' ');
      out.print( b.getBoardMin() );
      out.write(" </span>\r\n");
      out.write("			<span class=\"view_count\">| 조회수 ");
      out.print( b.getBoardCount() );
      out.write("</span>\r\n");
      out.write("			</span>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<br>\r\n");
      out.write("\r\n");
      out.write("		<div class=\"content_part\">\r\n");
      out.write("			<!-- 작성한 글이 들어가는 부분 -->\r\n");
      out.write("			");
      out.print( b.getBoardContent() );
      out.write("\r\n");
      out.write("			<input type=\"hidden\" name=\"content\" value=\"");
      out.print( b.getBoardContent() );
      out.write("\">\r\n");
      out.write("			<input type=\"hidden\" name=\"bNo\" value=\"");
      out.print( b.getBoardNo() );
      out.write("\">\r\n");
      out.write("		</div>\r\n");
      out.write("		<br>\r\n");
      out.write("		<div id=\"write_button\" style=\"text-align: right;\">\r\n");
      out.write("			");
 if(loginUser.getUserId().equals(b.getBoardWriter())) { 
      out.write("\r\n");
      out.write("			<input class=\"btn\" type=\"submit\" value=\"수정\">\r\n");
      out.write("			<input class=\"btn\" type=\"button\" onclick=\"deleteBoard();\" value=\"삭제\">\r\n");
      out.write("			");
 } 
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		</form>\r\n");
      out.write("		\r\n");
      out.write("		<br>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"comment_titleArea\"> ▒ 댓글 ▒</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"replyArea\">\r\n");
      out.write("			<div class=\"replyWriterArea\">\r\n");
      out.write("				<table id=\"replyWriterTable\">\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td colspan=\"3\" style=\"width:95%;\"><textarea rows=\"3\" style=\"width:100%; resize: none; border: 1px solid #00CED1;\" id=\"replyContent\"></textarea></td>\r\n");
      out.write("						<td style=\"text-align: left; width:5%;\"><button id=\"addReply\">댓글<br>등록</button></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("				</table>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"comment_partArea\" id=\"replySelectArea\">\r\n");
      out.write("			<!-- 댓글에 관련된 부분 -->\r\n");
      out.write("			<table id=\"replySelectTable\">\r\n");
      out.write("				");
 if(list == null) { 
      out.write("\r\n");
      out.write("					<tr><td colspan=\"3\">댓글이 없습니다.</td></tr>\r\n");
      out.write("				");
 } else { 
      out.write("\r\n");
      out.write("					");
 for(int i = 0; i < list.size(); i++) { 
      out.write("\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td><a href=\"#\"><img src=\".\\images\\propile.png\" width=\"30\" height=\"30\"></a> ");
      out.print( list.get(i).getNickName() );
      out.write("</td>\r\n");
      out.write("							<td>");
      out.print( list.get(i).getCommentContent() );
      out.write("</td>\r\n");
      out.write("							<td>");
      out.print( list.get(i).getCommentDate() );
      out.write(' ');
      out.print( list.get(i).getCommentHour() );
      out.write(' ');
      out.write(':');
      out.write(' ');
      out.print( list.get(i).getCommentMin() );
      out.write("</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("					");
 } 
      out.write("\r\n");
      out.write("				");
 } 
      out.write("\r\n");
      out.write("			</table>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<br>\r\n");
      out.write("	<div style=\"text-align: center;\">\r\n");
      out.write("		<button id=\"return_list\" onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/list.jo'\">목록으로</button>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script>\r\n");
      out.write("		function deleteBoard() {\r\n");
      out.write("			var bool = confirm('정말 삭제하시겠습니까?');\r\n");
      out.write("			if(bool) {\r\n");
      out.write("				$('#detailForm').attr('action', 'delete.jo');\r\n");
      out.write("				$('#detailForm').submit();\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		$('#addReply').on('click', function() {\r\n");
      out.write("			var writer = '");
      out.print( loginUser.getUserId() );
      out.write("';\r\n");
      out.write("			var content = $('#replyContent').val();\r\n");
      out.write("			var bNo = ");
      out.print( b.getBoardNo() );
      out.write(";\r\n");
      out.write("			\r\n");
      out.write("			$.ajax({\r\n");
      out.write("				url: 'insertComment.jo',\r\n");
      out.write("				data: {writer:writer, content:content, bNo:bNo},\r\n");
      out.write("				success: function(data) {\r\n");
      out.write("					console.log(data);\r\n");
      out.write("					\r\n");
      out.write("					$replyTable = $('#replySelectTable');\r\n");
      out.write("					$replyTable.html('');\r\n");
      out.write("					\r\n");
      out.write("					for(var i in data) {\r\n");
      out.write("						var $tr = $('<tr>');\r\n");
      out.write("						var $writerTd = $('<td>').text(data[i].nickName).css('width', '100px');\r\n");
      out.write("						var $contentTd = $('<td>').text(data[i].commetContent).css('width', '400px');\r\n");
      out.write("						var $dateTd = $('<td>').text(data[i].commentDate).css('width', '200px');\r\n");
      out.write("						\r\n");
      out.write("						$tr.append($writerTd);\r\n");
      out.write("						$tr.append($contentTd);\r\n");
      out.write("						$tr.append($dateTd);\r\n");
      out.write("						$replyTable.append($tr);\r\n");
      out.write("					}\r\n");
      out.write("					\r\n");
      out.write("					$('#replyContent').val('');\r\n");
      out.write("					\r\n");
      out.write("				},\r\n");
      out.write("				error: function(data) {\r\n");
      out.write("					console.log(data);\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("		});\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}