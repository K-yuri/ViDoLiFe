package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.Comment;

/**
 * Servlet implementation class boardReviewSelectServlet
 */
@WebServlet("/detail.re")
public class BoardReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReviewDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		String update = request.getParameter("upd");
		
		Board board = new BoardService().selectBoard(bNo, update);
		ArrayList<Attachment> fileList = new BoardService().selectThumbnail(bNo);
		
		ArrayList<Comment> list = new BoardService().selectCommentList(bNo);
		
		String page = null;
		if(board != null) {
			page = "WEB-INF/views/board/boardReviewDetail.jsp";
			request.setAttribute("board", board);
			request.setAttribute("fileList", fileList);
			request.setAttribute("list", list);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "리뷰 게시글 상세조회 실패");
		}
		request.getRequestDispatcher(page).forward(request, response);
		
		System.out.println(fileList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
