package search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import search.model.service.SearchService;
import search.model.vo.Search;

/**
 * Servlet implementation class SearchInfoServlet
 */
@WebServlet("/SerchInfoForm.do")
public class SearchInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		 int conNo = Integer.parseInt(request.getParameter("conNo"));
		
		String conTitle = request.getParameter("title");
		String conPicNewName = request.getParameter("mainImg");
		String conActor = request.getParameter("actor");
		String conGenre = request.getParameter("genre");
		String conSummary = request.getParameter("summary");
		String conType = request.getParameter("type");

		Search infoSc = new Search(conNo, conTitle, conGenre, conActor, conType, conSummary, null, conPicNewName, null);
		//System.out.println(infoSc);
		
		ArrayList<Search> info =  new SearchService().selectInfo(conNo);//작품번호로 검색
			
		
		request.setAttribute("info",info); //작품번호로 검색한 배열 info로 담아서 보내준다.
		request.getRequestDispatcher("WEB-INF/views/search/searchInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
