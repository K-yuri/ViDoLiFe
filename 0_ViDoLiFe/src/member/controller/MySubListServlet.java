package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;
import member.model.vo.Subscribe;

/**
 * Servlet implementation class MySubscribeListServlet
 */
@WebServlet("/subList.me")
public class MySubListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySubListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService mService = new MemberService();
		
		String userId = request.getParameter("userId");
		
		ArrayList<Subscribe> loginList = null;
		if(userId == null) {
			userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		} else {
			String loginId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
			loginList = mService.selectSubList(loginId);
		}
		
		Member member = mService.selectMember(userId);
		ArrayList<Subscribe> list = mService.selectSubList(userId);
		
		String page = null;
		
		if(list != null) {
			request.setAttribute("member", member);
			request.setAttribute("list", list);
			request.setAttribute("loginList", loginList);
			page = "WEB-INF/views/member/mySubscribeList.jsp";
		} else {
			request.setAttribute("msg", "구독 회원 목록 조회 실패");
			page = "WEB-INF/views/common/errorPage.jsp";
		}
		
		
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
