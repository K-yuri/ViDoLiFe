package search.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import search.model.dao.SearchDAO;
import search.model.vo.Search;

public class SearchService {	
	private SearchDAO sDAO = new SearchDAO();
	
	
	
	public ArrayList<Search> selectSearch(String serch_input, String cate) {
		Connection conn = getConnection();
		
		ArrayList<Search> selectSearch = sDAO.selectSearch(serch_input, cate, conn);
		
		close(conn);
		
		return selectSearch;
		
	}

	public ArrayList<Search> selectInfo(int conNo) {
		Connection conn = getConnection();
		
		ArrayList<Search> info = sDAO.selectInfo(conn, conNo); //info객체에 커넥션과 no담는다
		close(conn);
		
		return info;
	}

	public ArrayList<Search> selectGenre(String gerne) {
		
		Connection conn = getConnection();
		
		ArrayList<Search> selectGenre = sDAO.selectGenre(gerne,conn);
		
		return selectGenre;
	}

	
	}
	
	


