package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class UpdateReviewServlet
 */
@WebServlet("/update.re")
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("bNo"));
		String boardTitle = request.getParameter("title");
		String boardContent = request.getParameter("content");
		
		Board b = new Board(boardNo, boardTitle, null, null, null, 0, null, null, boardContent, null, null, null);
		
		int result = new BoardService().updateBoard(b);
		
		if(result > 0) {
			// 다시 내 글이 있는 곳으로 감
			response.sendRedirect("detail.re?bNo=" + boardNo + "&upd=Y");
		} else {
			request.setAttribute("msg", "리뷰게시글 수정 실패");
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
