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

/**
 * Servlet implementation class boardJoinListServlet
 */
@WebServlet("/list.jo")
public class BoardJoinListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardJoinListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int listCount; 		// 총 게시글 개수
		int currentPage; 	// 현제 페이지
		int pageLimit;		// 한 페이지에서 보일 페이지 수
		int boardLimit;		// 한 페이지에서 보일 게시글 수
		int maxPage;		// 가장 마지막 페이지
		int startPage;		// 페이징이 된 페이지 중 시작 페이지
		int endPage;		// 페이징이 된 페이지 중 마지막 페이지
		
		BoardService bService = new BoardService();
		
		listCount = bService.getListJoinCount();
		
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			// currentPage가 null이 아니다 -> 파라미터로 currentPage가 들어왔다 -> 페이징 처리가 된 버튼을 눌렀다
			// currentPage가 null이다 -> 처음 페이지에 들어왔다 -> currentPage = 1
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		// 페이징처리 3단계 : boardLimit와 pageLimit 설정
		pageLimit = 10;
		boardLimit = 10;
		
		// 페이징처리 4단계 : 각 변수에 알맞은 계산식 작성
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		endPage = startPage + (pageLimit - 1);
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		ArrayList<Board> list = bService.selectJoinList(pi);
		
		String page = null;
		if(list != null) {
			page = "WEB-INF/views/board/boardJoinList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "단체관람 게시판 조회 실패");
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
