package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import member.model.vo.Member;
import member.model.vo.Notification;
import member.model.vo.Subscribe;

public class MemberDAO {
	
	private Properties prop = null;
	
	public MemberDAO() {
		prop = new Properties();
		String fileName = MemberDAO.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member loginMember(String userId, String userPwd, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;
		
		String query = prop.getProperty("login");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member(rset.getString("USER_ID"),
									   rset.getString("USER_PWD"),
									   rset.getString("USER_NAME"),
									   rset.getString("USER_NICK"),
									   rset.getString("USER_EMAIL"),
									   rset.getString("USER_PROFILE_MSG"),
									   rset.getString("USER_PIC_ORIGIN"),
									   rset.getString("USER_PIC_NEW"),
									   rset.getString("USER_PIC_PATH"),
									   rset.getString("USER_ADMIN"),
									   rset.getString("USER_STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return loginUser;
		
	

	}

	public Member selectMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		
		String query = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member(rset.getString("user_id"),
									rset.getString("user_pwd"),
									rset.getString("user_name"),
									rset.getString("user_nick"),
									rset.getString("user_email"),
									rset.getString("user_profile_msg"),
									rset.getString("user_pic_origin"),
									rset.getString("user_pic_new"),
									rset.getString("user_pic_path"),
									rset.getString("user_admin"),
									rset.getString("user_status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getUserNick());
			pstmt.setString(2, m.getUserProfileMsg());
			pstmt.setString(3, m.getUserPicOrigin());
			pstmt.setString(4, m.getUserPicNew());
			pstmt.setString(5, m.getUserPicPath());
			pstmt.setString(6, m.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updatePwd(Connection conn, String userId, String userPwd, String newPwd) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatePwd");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPwd);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteMemSub(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMemSub");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Subscribe> selectSubList(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Subscribe> list = null;
		
		String query = prop.getProperty("selectSubList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Subscribe>();
			
			while(rset.next()) {
				Subscribe s = new Subscribe(rset.getInt("sub_no"),
											rset.getString("from_user"),
											rset.getString("to_user"),
											rset.getString("user_nick"),
											rset.getString("user_pic_new"),
											rset.getString("user_pic_path"));
				
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

	public int deleteSub(Connection conn, String fromUser, String toUser) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteSub");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fromUser);
			pstmt.setString(2, toUser);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Subscribe selectSub(Connection conn, String loginId, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Subscribe sub = null;
		
		String query = prop.getProperty("selectSub");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginId);
			pstmt.setString(2, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				sub = new Subscribe();
				sub.setSubNo(rset.getInt("sub_no"));
				sub.setFromUser(rset.getString("from_user"));
				sub.setToUser(rset.getString("to_user"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return sub;
	}

	public int insertSub(Connection conn, String fromUser, String toUser) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertSub");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fromUser);
			pstmt.setString(2, toUser);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Notification> selectNotiList(Connection conn, String notiToUser) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notification> list = null;
		
		String query = prop.getProperty("selectNotiList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notiToUser);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Notification>();
			while(rset.next()) {
				Notification n = new Notification(rset.getInt("noti_no"),
												  rset.getString("noti_type"),
												  rset.getDate("noti_date_time"),
												  rset.getDate("noti_read_time"),
												  rset.getString("noti_check"),
												  rset.getString("noti_to_user"),
												  rset.getString("noti_from_user"),
												  rset.getString("user_nick"),
												  rset.getInt("board_no"),
												  rset.getString("board_title"),
												  rset.getString("board_class"));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int checkNoti(Connection conn, int notiNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("checkNoti");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, notiNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getUserNick());
			pstmt.setString(5, member.getUserEmail());
			pstmt.setString(6, member.getUserProfileMsg());
			pstmt.setString(7, member.getUserPicOrigin());
			pstmt.setString(8, member.getUserPicNew());
			pstmt.setString(9, member.getUserPicPath());
			pstmt.setString(10, member.getUserAdmin());
			pstmt.setString(11, member.getStatus());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int checkId(Connection conn, String inputId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("checkId");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public String searchId(String userName, String userEmail, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String searchUser = null;
		
		String query = prop.getProperty("searchId");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, userEmail);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				searchUser = rset.getString("USER_ID");
							 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return searchUser;
	}

	public int updatePwd(Connection conn, String userId, String newPwd) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateSearchPwd");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
