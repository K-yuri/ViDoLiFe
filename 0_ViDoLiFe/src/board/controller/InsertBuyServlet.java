package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;
import member.model.vo.Member;

/**
 * Servlet implementation class InsertBuyServlet
 */
@WebServlet("/insert.bu")
public class InsertBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardTitle = request.getParameter("title");
		String boardContent = request.getParameter("content");
		String boardWriter = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
		Board b = new Board();
		b.setBoardTitle(boardTitle);
		b.setBoardContent(boardContent);
		b.setBoardWriter(boardWriter);
		b.setBoardClass("3");
		
		int result = new BoardService().insertBoard(b);
		
		if(result > 0) {
			response.sendRedirect("list.bu");
		} else {
			request.setAttribute("msg", "리뷰게시글 등록 실패");
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
