package member.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmMailServlet
 */
@WebServlet("/confirmMail.me")
public class ConfirmMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmMailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String receiver = request.getParameter("userEmail");
		String title = "[비도라이프] 비밀번호 찾기 및 변경을 위한 확인 메일";
//		String content = "<h2 class=\"card-title\" style=\"color:red;\"><img id=\"logo\" src=\"images/vidolife_logo.png\"/></h2><br>"
//				+ "본 메일은 현재 회원님의 비밀번호를 변경하기 위한 인증메일 입니다.";
		String code = "회원님의 인증번호는 : " + request.getParameter("code_check");
		String host = "smtp.naver.com";
		String sender = "ddatto01@naver.com";
		String senderPwd = "iceman032211!";
		
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.host", host);
		prop.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, senderPwd);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			request.setAttribute("code", code);
			message.setText(code, "UTF-8");
			
			Transport.send(message);
			
			request.getRequestDispatcher("WEB-INF/views/member/searchPwdInsertCode.jsp").forward(request, response);
		} catch (AddressException e) {
			e.printStackTrace();
			response.getWriter().println("fail");
		} catch (MessagingException e) {
			e.printStackTrace();
			response.getWriter().println("fail");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
