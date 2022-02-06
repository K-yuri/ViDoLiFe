package board.controller;

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
import search.model.service.SearchService;
import search.model.vo.Search;

/**
 * Servlet implementation class BoardReviewSearchServlet
 */
@WebServlet("/search.bu")
public class BoardBuySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardBuySearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input = request.getParameter("input"); 	// 검색어	
		String field = request.getParameter("field");	// 분류(제목, 내용, 작성자)
		
		System.out.println(input);
		System.out.println(field);

		ArrayList<Board> list = new BoardService().searchBuyList(input, field);

		request.setAttribute("list", list);
		request.setAttribute("field", field);
		
		request.getRequestDispatcher("WEB-INF/views/board/boardBuySearchList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
