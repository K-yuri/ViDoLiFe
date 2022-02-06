package board.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.Comment;
import board.model.vo.PageInfo;
import search.model.vo.Search;

public class BoardService {
	
	private BoardDAO bDAO = new BoardDAO();

	public int getUserListCount(String userId) {
		Connection conn = getConnection();
		
		int listCount = bDAO.getUserListCount(conn, userId);
		
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Board> selectUserBoardList(PageInfo pi, String userId) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = bDAO.selectUserBoardList(conn, pi, userId);
		
		close(conn);
		
		return list;
	}

	public int getListReivewCount() {
		Connection conn = getConnection();
		
		int listCount = bDAO.getListReivewCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public int getListJoinCount() {
		Connection conn = getConnection();
		
		int listCount = bDAO.getListJoinCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public int getListBuyCount() {
		Connection conn = getConnection();
		
		int listCount = bDAO.getListBuyCount(conn);
		
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Board> selectReviewList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = bDAO.selectReviewList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Board> selectJoinList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = bDAO.selectJoinList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Board> selectBuyList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = bDAO.selectBuyList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public Board selectBoard(int bNo, String upd) {
		Connection conn = getConnection();
		
		int result = 0;
		if(!(upd != null && upd.equals("Y"))) {
			result = bDAO.updateCount(conn, bNo);
		}
		
		
		Board b = bDAO.selectBoard(conn, bNo);
		if(result > 0 && b != null) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return b;
	}

	public int insertBoard(Board b) {
		Connection conn = getConnection();
		
		int result = bDAO.insertBoard(conn, b);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public int updateBoard(Board b) {
		Connection conn = getConnection();
		
		int result = bDAO.updateBoard(conn, b);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteBoard(int bNo) {
		Connection conn = getConnection();
		
		int result = bDAO.deleteBoard(conn, bNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<Comment> selectCommentList(int bNo) {
		Connection conn = getConnection();
		
		ArrayList<Comment> list = bDAO.selectCommentList(bNo, conn);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Comment> insertComment(Comment c) {
		Connection conn = getConnection();
		
		int result = bDAO.insertComment(conn, c);
		
		ArrayList<Comment> list = null;
		if(result > 0) {
			list = bDAO.selectCommentList(c.getCommentBNo(), conn);
			
			if(list != null) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return list;
	}

	public ArrayList<Board> selectBestList() {
		Connection conn = getConnection();
		
		ArrayList<Board> list = bDAO.selectBestList(conn);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Board> searchReviewList(String input, String field) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = bDAO.searchReviewList(input, field, conn);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Board> searchJoinList(String input, String field) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = bDAO.searchJoinList(input, field, conn);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Board> searchBuyList(String input, String field) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = bDAO.searchBuyList(input, field, conn);
		
		close(conn);
		
		return list;
	}

	public int insertThumbnail(Board b, ArrayList<Attachment> fileList) {
		Connection conn = getConnection();
		
		int result1 = bDAO.insertBoard(conn, b);
		int result2 = bDAO.insertAttachment(conn, fileList);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 + result2;
	}

	public ArrayList<Attachment> selectThumbnail(int bNo) {
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = bDAO.selectThumbnail(bNo, conn);
		
		close(conn);
		
		return list;
	}
}
