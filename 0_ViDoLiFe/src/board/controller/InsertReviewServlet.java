package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import board.model.service.BoardService;
import board.model.vo.Attachment;
import board.model.vo.Board;
import common.MyFileRenamePolicy;
import member.model.vo.Member;

/**
 * Servlet implementation class InsertReviewServlet
 */
@WebServlet("/insert.re")
public class InsertReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 1024*1024*10; // 10Mbyte
			String root = request.getSession().getServletContext().getRealPath("/"); // 웹 서버 컨테이너 경로 추출: WebContent
			String savePath = root + "thumbnail_uploadFiles/";
			
			File f = new File(savePath);
			if(!f.exists()) {
				f.mkdirs();
			}
			
			// DefaultFileRenamePolicy (cos.jar 안에 존재)
			// : 같은 파일 명이 있는지 검사하고, 있을 경우 파일 명 뒤에 숫자를 붙임
			// ex. aaa.jpg, aaa1.jpg, aaa2.jpg
			
			System.out.println(savePath);
			// cos.jar
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
			ArrayList<String> saveFiles = new ArrayList<String>();		// 파일의 바뀐 이름을 저장할 ArrayList
			ArrayList<String> originFiles = new ArrayList<String>();	// 파일의 원래 이름을 저장할 ArrayList
			
			Enumeration<String> files = multiRequest.getFileNames();
			
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				
				if(multiRequest.getFilesystemName(name) != null) {
					saveFiles.add(multiRequest.getFilesystemName(name));
					originFiles.add(multiRequest.getOriginalFileName(name));
				}
			}
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			String writer = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
			
			Board b = new Board();
			b.setBoardTitle(title);
			b.setBoardContent(content);
			b.setBoardWriter(writer);
			b.setBoardClass("1");
			
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			for(int i = originFiles.size()-1; i >= 0; i--) {
				Attachment a = new Attachment();
				a.setFilePath(savePath);
				a.setOriginName(originFiles.get(i));
				a.setChangeName(saveFiles.get(i));
				
				if(i == originFiles.size()-1) {
					a.setFileLevel(0);
				} else {
					a.setFileLevel(1);
				}
				
				fileList.add(a);
			}
			
			int result = new BoardService().insertThumbnail(b, fileList);	
			
			if(result >= 1+fileList.size()) {
				response.sendRedirect("list.re");
			} else {
				request.setAttribute("msg", "리뷰게시글 등록 실패");
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
				
				for(int i = 0; i < saveFiles.size(); i++) {
					File fail = new File(savePath + saveFiles.get(i));
					fail.delete();
				}
			}
		}
		
//		String boardTitle = request.getParameter("title");
//		String boardContent = request.getParameter("content");
//		String boardWriter = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
//		
//		Board b = new Board();
//		b.setBoardTitle(boardTitle);
//		b.setBoardContent(boardContent);
//		b.setBoardWriter(boardWriter);
//		b.setBoardClass("1");
		
		//int result = new BoardService().insertBoard(b);
		
//		if(result > 0) {
//			response.sendRedirect("list.re");
//		} else {
//			request.setAttribute("msg", "리뷰게시글 등록 실패");
//			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
