package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import member.model.vo.Member;

/**
 * Servlet implementation class UpdateMemberFormServlet
 */
@WebServlet("/updateForm.me")
public class UpdateMemberFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("myId");
		String userName = request.getParameter("myName");
		String userEmail = request.getParameter("myEmail");
		String userNick = request.getParameter("myNickName");
		String userProfileMsg = request.getParameter("myProfileMsg");
		String userPicSrc = request.getParameter("profileImg");
		
		Member m = new Member(userId, null, userName, userNick, userEmail, userProfileMsg, null, null, userPicSrc, null, null);
		
		request.setAttribute("member", m);
		request.getRequestDispatcher("WEB-INF/views/member/updateInfoForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
