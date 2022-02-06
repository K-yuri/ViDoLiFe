package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Subscribe;

/**
 * Servlet implementation class SubscribeServlet
 */
@WebServlet("/subscribe.me")
public class SubscribeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubscribeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String fromUser = request.getParameter("fromUser");
		String toUser = request.getParameter("toUser");
		String pageUser = request.getParameter("pageUser");
		String page = request.getParameter("page");
		
		Subscribe sub = new MemberService().insertSub(fromUser, toUser);
		
		if(sub != null) {
			if(page != null) {
				response.sendRedirect("myProfile.me?userId=" + toUser);
			} else {
				response.sendRedirect("subList.me?userId=" + pageUser);
			}
			
		} else {
			request.setAttribute("msg", "회원 구독 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
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
