package member.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import member.model.dao.MemberDAO;
import member.model.vo.Member;
import member.model.vo.Notification;
import member.model.vo.Subscribe;

public class MemberService {
	
	private MemberDAO mDAO = new MemberDAO();
	
	// login
	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		
		Member loginUser = mDAO.loginMember(userId, userPwd, conn);
		
		close(conn);
		
		return loginUser;
	}

	public Member selectMember(String userId) {
		Connection conn = getConnection();
		
		Member member = mDAO.selectMember(conn, userId);

		close(conn);
		
		return member;
	}

	public int updateMember(Member m) {
		Connection conn = getConnection();
		
		int result = mDAO.updateMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int updatePwd(String userId, String userPwd, String newPwd) {
		Connection conn = getConnection();
		
		int result = mDAO.updatePwd(conn, userId, userPwd, newPwd);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteMember(String userId) {
		Connection conn = getConnection();
		
		int result1 = mDAO.deleteMember(conn, userId);
		int result2 = mDAO.deleteMemSub(conn, userId);
		
		if((result1 + result2) >= 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 + result2;
	}

	public ArrayList<Subscribe> selectSubList(String userId) {
		Connection conn = getConnection();
		
		ArrayList<Subscribe> list = mDAO.selectSubList(conn, userId);
		
		close(conn);
		
		return list;
	}

	public int deleteSub(String fromUser, String toUser) {
		Connection conn = getConnection();
		
		int result = mDAO.deleteSub(conn, fromUser, toUser);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Subscribe selectSub(String loginId, String userId) {
		Connection conn = getConnection();
		
		Subscribe sub = mDAO.selectSub(conn, loginId, userId);
		
		close(conn);
		
		return sub;
	}

	public Subscribe insertSub(String fromUser, String toUser) {
		Connection conn = getConnection();
		
		int result = mDAO.insertSub(conn, fromUser, toUser);
		
		Subscribe sub = null;
		if(result > 0) {
			sub = mDAO.selectSub(conn, fromUser, toUser);
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return sub;
	}

	public ArrayList<Notification> selectNotiList(String notiToUser) {
		Connection conn = getConnection();
		
		ArrayList<Notification> list = mDAO.selectNotiList(conn, notiToUser);
		
		close(conn);
		
		return list;
	}

	public int checkNoti(int notiNo) {
		Connection conn = getConnection();
		
		int result = mDAO.checkNoti(conn, notiNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int insertMember(Member member) {
		Connection conn = getConnection();
		
		int result = mDAO.insertMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int checkId(String inputId) {
		Connection conn = getConnection();
		
		int result = mDAO.checkId(conn, inputId);
		
		close(conn);
		
		return result;
	}


	public String searchId(String userName, String userEmail) {
		Connection conn = getConnection();
		
		String searchUser = mDAO.searchId(userName, userEmail, conn);
		
		close(conn);
		
		return searchUser;
	}

	public int updatePwd(String userId, String newPwd) {
		Connection conn = getConnection();
		
		int result = mDAO.updatePwd(conn, userId ,newPwd);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
