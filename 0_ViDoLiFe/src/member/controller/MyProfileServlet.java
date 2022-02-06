package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.PageInfo;
import member.model.service.MemberService;
import member.model.vo.Member;
import member.model.vo.Subscribe;

/**
 * Servlet implementation class MyProfileServlet
 */
@WebServlet("/myProfile.me")
public class MyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService mService = new MemberService();
		BoardService bService = new BoardService();
		
		String userId = request.getParameter("userId");
		
		Subscribe sub = null;
		if(userId == null) {
			// login한 사용자의 프로필 페이지를 볼 때
			userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		} else {
			// 다른 사용자의 프로필 페이지를 볼 때
			String loginId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
			sub = mService.selectSub(loginId, userId);
		}
		
		
		Member m = mService.selectMember(userId);
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = bService.getUserListCount(userId);
		
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		pageLimit = 10;
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Board> list = bService.selectUserBoardList(pi, userId);
		
		
		String page = null;
		if(m != null && list != null) {
			request.setAttribute("member", m);
			request.setAttribute("subscribe", sub);
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			page = "WEB-INF/views/member/myProfile.jsp";
		} else {
			request.setAttribute("msg", "회원 프로필 조회 실패");
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
