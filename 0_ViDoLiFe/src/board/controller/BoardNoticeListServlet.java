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
 * Servlet implementation class BoardNoticeListServlet
 */
@WebServlet("/list.no")
public class BoardNoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardNoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이징 처리를 하기 위해 필요한 변수 설정
		int listCount;		// 총 게시글 개수
		int currentPage;	// 현재 페이지
		int pageLimit;		// 한 페이지에서 보일 페이지 수
		int boardLimit;		// 한 페이지에서 보일 게시글 수
		int maxPage;		// 가장 마지막 페이지
		int startPage;		// 페이징이 된 페이지 중 시작 페이지
		int endPage;		// 페이징이 된 페이지 중 마지막 페이지
		
		BoardService bServiec = new BoardService();
		// 페이징 처리 1단계
		listCount = bServiec.getNoticeListCount();
		
		// 페이징 처리 2단계 
		currentPage = 1;
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		// 페이징 처리 3단계
		pageLimit = 10;
		boardLimit = 10;
		
		// 페이징 처리 4단계
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		startPage = (currentPage -1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, boardLimit, maxPage, startPage, endPage);

		ArrayList<Board> list = bServiec.selectNoticeList(pi);
		
		System.out.println(list);
		String page = null;
		if(list != null) { // noticeList.jsp
			page = "WEB-INF/views/board/boardNoticeList.jsp";
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
		} else {	//errorPage.jsp
			page = "WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("msg", "공지사항 조회 실패");
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
