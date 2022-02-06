package member.model.vo;

import java.sql.Date;

public class Notification {

	private int notiNo;
	private String notiType;
	private Date notiDateTime;
	private Date notiReadTime;
	private String notiCheck;
	private String notiToUser;
	private String notiFromUser;
	private String notiFromUserNick;
	private int boardNo;
	private String boardTitle;
	private String boardClass; // 게시글 타입(리뷰=1/단체관람=2/공동구매=3)
	
	public Notification() {}

	public Notification(int notiNo, String notiType, Date notiDateTime, Date notiReadTime, String notiCheck,
			String notiToUser, String notiFromUser, String notiFromUserNick, int boardNo, String boardTitle,
			String boardClass) {
		super();
		this.notiNo = notiNo;
		this.notiType = notiType;
		this.notiDateTime = notiDateTime;
		this.notiReadTime = notiReadTime;
		this.notiCheck = notiCheck;
		this.notiToUser = notiToUser;
		this.notiFromUser = notiFromUser;
		this.notiFromUserNick = notiFromUserNick;
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardClass = boardClass;
	}

	public int getNotiNo() {
		return notiNo;
	}

	public void setNotiNo(int notiNo) {
		this.notiNo = notiNo;
	}

	public String getNotiType() {
		return notiType;
	}

	public void setNotiType(String notiType) {
		this.notiType = notiType;
	}

	public Date getNotiDateTime() {
		return notiDateTime;
	}

	public void setNotiDateTime(Date notiDateTime) {
		this.notiDateTime = notiDateTime;
	}

	public Date getNotiReadTime() {
		return notiReadTime;
	}

	public void setNotiReadTime(Date notiReadTime) {
		this.notiReadTime = notiReadTime;
	}

	public String getNotiCheck() {
		return notiCheck;
	}

	public void setNotiCheck(String notiCheck) {
		this.notiCheck = notiCheck;
	}

	public String getNotiToUser() {
		return notiToUser;
	}

	public void setNotiToUser(String notiToUser) {
		this.notiToUser = notiToUser;
	}

	public String getNotiFromUser() {
		return notiFromUser;
	}

	public void setNotiFromUser(String notiFromUser) {
		this.notiFromUser = notiFromUser;
	}

	public String getNotiFromUserNick() {
		return notiFromUserNick;
	}

	public void setNotiFromUserNick(String notiFromUserNick) {
		this.notiFromUserNick = notiFromUserNick;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardClass() {
		return boardClass;
	}

	public void setBoardClass(String boardClass) {
		this.boardClass = boardClass;
	}

	@Override
	public String toString() {
		return "Notification [notiNo=" + notiNo + ", notiType=" + notiType + ", notiDateTime=" + notiDateTime
				+ ", notiReadTime=" + notiReadTime + ", notiCheck=" + notiCheck + ", notiToUser=" + notiToUser
				+ ", notiFromUser=" + notiFromUser + ", notiFromUserNick=" + notiFromUserNick + ", boardNo=" + boardNo
				+ ", boardTitle=" + boardTitle + ", boardClass=" + boardClass + "]";
	}

}
