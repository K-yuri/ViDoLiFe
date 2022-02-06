package member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import common.MyFileRenamePolicy;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/update.me")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 10;
			String root = request.getSession().getServletContext().getRealPath("/");
			String savePath = root + "uploadFiles/";
			
			File f = new File(savePath);
			if(!f.exists()) {
				f.mkdirs();
			}
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			String userId = multiRequest.getParameter("myId");
			String userNick = multiRequest.getParameter("myNickName");
			String userProfileMsg = multiRequest.getParameter("myProfileMsg");
			String userPicOrigin = multiRequest.getOriginalFileName("selectImg");
			String userPicNew = multiRequest.getFilesystemName("selectImg");
			
			
			Member m = new Member();
			m.setUserId(userId);
			m.setUserNick(userNick);
			m.setUserProfileMsg(userProfileMsg);
			m.setUserPicOrigin(userPicOrigin);
			m.setUserPicNew(userPicNew);
			m.setUserPicPath(savePath);
			
			int result = new MemberService().updateMember(m);
			
			if(result > 0) {
				Member loginUser = new MemberService().selectMember(userId);
				request.getSession().setAttribute("loginUser", loginUser);
				response.sendRedirect("myInfo.me");
			} else {
				request.setAttribute("msg", "회원 정보 수정 실패");
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
			}
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
