package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class SearchIdServlet
 */
@WebServlet("/search.me")
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		 
		 String userName = request.getParameter("userName");
		 String userEmail = request.getParameter("userEmail");
		 
		 String searchUser = new MemberService().searchId(userName, userEmail);
		 
		 if(searchUser != null) {
			 request.setAttribute("alertMsg", "회원님의 아이디는 "+ searchUser + "입니다");
			 RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/idResultPage.jsp");
			 view.forward(request, response);
		 } else {
			 request.setAttribute("msg", "해당하는 회원정보가 존재하지 않습니다.");
			 RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp");
			 view.forward(request, response);
			 
		 }
		 
		 System.out.println(userName);
		 System.out.println(userEmail);
		 System.out.println(searchUser);
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
