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
 * Servlet implementation class SearchFormServlet
 */
@WebServlet("/SerchForm.do") //
public class SearchFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String search = request.getParameter("search"); 		
		String cate = request.getParameter("cate");
		
		
		ArrayList<Search> list = new SearchService().selectSearch(search, cate); //카테고리와 검색내용으로 검색
		String gerne = list.get(0).getConGenre(); //검색한 내용의 장르 뽑아주기 
	

		ArrayList<Search> greList = new SearchService().selectGenre(gerne);
		
		request.setAttribute("greList", greList);	
		request.setAttribute("list", list);
		request.setAttribute("cate", cate);

		request.getRequestDispatcher("WEB-INF/views/search/searchResult.jsp").forward(request, response);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
