package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;

/**
 * Servlet implementation class BoardCheckDeleteServlet
 */
@WebServlet("/CheckDelete.bo")
public class BoardCheckDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCheckDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valueArr = request.getParameter("valueArr");
		int result = 0;
		
		String[] splitValue = valueArr.split(" "); 
		for(int i=0;i < splitValue.length; i++) { 
			System.out.println(splitValue[i]);
			result = new BoardService().Checkdelete(splitValue[i]);
		}

		if(result > 0) {
			response.sendRedirect("list.no");
		} else {
			request.setAttribute("msg", "공지사항 삭제 실패");
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
