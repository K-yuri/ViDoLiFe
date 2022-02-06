package search.model.dao;

import static common.JDBCTemplate.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import search.model.vo.Search;



public class SearchDAO {
	
	private Properties prop = null;
	
	public SearchDAO() {
		prop = new Properties();
		
		String fileName = SearchDAO.class.getResource("/sql/search/search-query.properties").getPath();
	
		try {
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public ArrayList<Search> selectSearch(String search, String cate, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Search> list = null;
		
		String query = prop.getProperty("select" + cate); 
		
		try {
			pstmt = conn.prepareStatement(query);
			
			if(cate.equals("title")) {
				pstmt.setString(1, "%" + search + "%");
			} else {
				pstmt.setString(1, search);
			}
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Search>();
			
			while(rset.next()) {		//행의 개수를 정확히 모르니까 while사용
				Search s = new Search(rset.getInt("con_no"),
									  rset.getString("con_title"),
									  rset.getString("con_genre"),
									  rset.getString("con_actor"),
									  rset.getString("con_type"),
									  rset.getString("con_summary"),
									  rset.getString("con_pic_origin_name"),
									  rset.getString("con_pic_new_name"),
									  rset.getString("con_pic_path"));
				list.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
			
		return list;

	}


	public ArrayList<Search> selectInfo(Connection conn, int conNo) {
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		ArrayList<Search> list = null;
		
		String query = prop.getProperty("selectInfo");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, conNo);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Search>();
			while(rset.next()) { 				//if로 했는데 whil로 해야하는지 확인하기!!
				 Search sc = new Search(rset.getInt("con_no"),
										  rset.getString("con_title"),
										  rset.getString("con_genre"),
										  rset.getString("con_actor"),
										  rset.getString("con_type"),
										  rset.getString("con_summary"),
										  rset.getString("con_pic_origin_name"),
										  rset.getString("con_pic_new_name"),
										  rset.getString("con_pic_path"));
				 list.add(sc);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(rset);
		}
		
		
		return list;
	}


	public ArrayList<Search> selectGenre(String gerne, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Search> list = null;
		
		String query = prop.getProperty("selectGenre");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, gerne);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Search>();
			
			while(rset.next()) { 				//if로 했는데 whil로 해야하는지 확인하기!!
				 Search gen = new Search(rset.getInt("con_no"),
										  rset.getString("con_title"),
										  rset.getString("con_genre"),
										  rset.getString("con_actor"),
										  rset.getString("con_type"),
										  rset.getString("con_summary"),
										  rset.getString("con_pic_origin_name"),
										  rset.getString("con_pic_new_name"),
										  rset.getString("con_pic_path"));
				 list.add(gen);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}



}
