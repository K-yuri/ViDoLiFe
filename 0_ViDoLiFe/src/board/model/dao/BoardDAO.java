package board.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.Comment;
import board.model.vo.PageInfo;
import search.model.vo.Search;

public class BoardDAO {
	private Properties prop = null;
	
	public BoardDAO() {
		prop = new Properties();
		
		String fileName = BoardDAO.class.getResource("/sql/board/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getUserListCount(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getUserListCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Board> selectUserBoardList(Connection conn, PageInfo pi, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("selectUserBoardList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board(rset.getInt("board_no"),
									rset.getString("board_title"),
									rset.getDate("board_date"),
									rset.getString("hour"),
									rset.getString("min"),
									rset.getInt("board_count"),
									rset.getString("user_id"),
									rset.getString("user_nick"),
									rset.getString("board_content"),
									rset.getString("board_class"),
									rset.getString("board_notice"),
									rset.getString("board_status"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int getListReivewCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getListReviewCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}
	
	public int getListJoinCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getListJoinCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}
	
	public int getListBuyCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getListBuyCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public ArrayList<Board> selectReviewList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("selectReviewList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board(rset.getInt("board_no"),
									rset.getString("board_title"),
									rset.getDate("board_date"),
									rset.getString("hour"),
									rset.getString("min"),
									rset.getInt("board_count"),
									rset.getString("user_id"),
									rset.getString("user_nick"),
									rset.getString("board_content"),
									rset.getString("board_class"),
									rset.getString("board_notice"),
									rset.getString("board_status"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Board> selectJoinList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("selectJoinList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board(rset.getInt("board_no"),
									rset.getString("board_title"),
									rset.getDate("board_date"),
									rset.getString("hour"),
									rset.getString("min"),
									rset.getInt("board_count"),
									rset.getString("user_id"),
									rset.getString("user_nick"),
									rset.getString("board_content"),
									rset.getString("board_class"),
									rset.getString("board_notice"),
									rset.getString("board_status"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Board> selectBuyList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("selectBuyList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board(rset.getInt("board_no"),
									rset.getString("board_title"),
									rset.getDate("board_date"),
									rset.getString("hour"),
									rset.getString("min"),
									rset.getInt("board_count"),
									rset.getString("user_id"),
									rset.getString("user_nick"),
									rset.getString("board_content"),
									rset.getString("board_class"),
									rset.getString("board_notice"),
									rset.getString("board_status"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int updateCount(Connection conn, int bNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Board selectBoard(Connection conn, int bNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		String query = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				b = new Board(rset.getInt("board_no"),
						rset.getString("board_title"),
						rset.getDate("board_date"),
						rset.getString("hour"),
						rset.getString("min"),
						rset.getInt("board_count"),
						rset.getString("user_id"),
						rset.getString("user_nick"),
						rset.getString("board_content"),
						rset.getString("board_class"),
						rset.getString("board_notice"),
						rset.getString("board_status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(conn);
		}
		return b;
	}

	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setString(3, b.getBoardClass());
			pstmt.setString(4, b.getBoardWriter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setInt(3, b.getBoardNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteBoard(Connection conn, int bNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Comment> selectCommentList(int bNo, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Comment> list = null;
		
		String query = prop.getProperty("selectCommentList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Comment>();
			while(rset.next()) {
				list.add(new Comment(rset.getInt("comment_no"),
								   rset.getString("comment_content"),
								   rset.getInt("board_no"),
								   rset.getDate("comment_date"),
								   rset.getString("hour"),
								   rset.getString("min"),
								   rset.getString("user_id"),
								   rset.getString("user_nick"),
								   rset.getString("comment_status")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(conn);
		}
		
		return list;
	}

	public int insertComment(Connection conn, Comment c) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertComment");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getCommentContent());
			pstmt.setInt(2, c.getCommentBNo());
			pstmt.setString(3, c.getCommentWriter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Board> selectBestList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("selectBestList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board(rset.getInt("board_no"),
									rset.getString("board_title"),
									rset.getDate("board_date"),
									rset.getString("hour"),
									rset.getString("min"),
									rset.getInt("board_count"),
									rset.getString("user_id"),
									rset.getString("user_nick"),
									rset.getString("board_content"),
									rset.getString("board_class"),
									rset.getString("board_notice"),
									rset.getString("board_status"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public ArrayList<Board> searchReviewList(String input, String field, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("searchReview" + field);
		
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + input + "%");
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board(rset.getInt("board_no"),
									rset.getString("board_title"),
									rset.getDate("board_date"),
									rset.getString("hour"),
									rset.getString("min"),
									rset.getInt("board_count"),
									rset.getString("user_id"),
									rset.getString("user_nick"),
									rset.getString("board_content"),
									rset.getString("board_class"),
									rset.getString("board_notice"),
									rset.getString("board_status"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
			
		return list;
	}
	
	public ArrayList<Board> searchJoinList(String input, String field, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("searchJoin" + field);
		
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + input + "%");
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board(rset.getInt("board_no"),
									rset.getString("board_title"),
									rset.getDate("board_date"),
									rset.getString("hour"),
									rset.getString("min"),
									rset.getInt("board_count"),
									rset.getString("user_id"),
									rset.getString("user_nick"),
									rset.getString("board_content"),
									rset.getString("board_class"),
									rset.getString("board_notice"),
									rset.getString("board_status"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
			
		return list;
	}
	
	public ArrayList<Board> searchBuyList(String input, String field, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("searchBuy" + field);
		
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%" + input + "%");
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board(rset.getInt("board_no"),
									rset.getString("board_title"),
									rset.getDate("board_date"),
									rset.getString("hour"),
									rset.getString("min"),
									rset.getInt("board_count"),
									rset.getString("user_id"),
									rset.getString("user_nick"),
									rset.getString("board_content"),
									rset.getString("board_class"),
									rset.getString("board_notice"),
									rset.getString("board_status"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
			
		return list;
	}

	public ArrayList<Attachment> selectThumbnail(int bNo, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = null;
		
		String query = prop.getProperty("selectThumbnail");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNo);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Attachment>();
			while(rset.next()) {
				Attachment a = new Attachment();
				a.setFileId(rset.getInt("pic_no"));
				a.setOriginName(rset.getString("pic_origin_name"));
				a.setChangeName(rset.getString("pic_new_name"));
				a.setFilePath(rset.getString("pic_path"));
				a.setUploadDate(rset.getDate("pic_date"));
				
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(conn);
		}
		return list;
	}

	public int insertAttachment(Connection conn, ArrayList<Attachment> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		
		try {
			for(int i = 0; i < fileList.size(); i++) {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, fileList.get(i).getOriginName());
				pstmt.setString(2, fileList.get(i).getChangeName());
				pstmt.setString(3, fileList.get(i).getFilePath());
				pstmt.setInt(4, fileList.get(i).getFileLevel());
				
				result += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}	
		return result;
	}
}
