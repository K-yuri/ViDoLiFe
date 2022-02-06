package board.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Board {
	private int boardNo;			// 게시글 번호
	private String boardTitle;		// 게시글 제목	
	private Date boardDate;			// 게시글 작성 날짜
	private String boardHour;		// 게시글 작성 시
	private String boardMin;		// 게시글 작성 분
	private int boardCount;			// 조회수
	private String boardWriter;		// 게시글 작성자
	private String nickName;		// 작성자 닉네임
	private String boardContent;	// 게시글 내용
	private String boardClass;		// 게시글 타입(리뷰=1/단체관람=2/공동구매=3)
	private String boardNotice;		// 공지사항 여부
	private String status;			// 상태
	
	public Board() {}

	public Board(int boardNo, String boardTitle, Date boardDate, String boardHour, String boardMin, int boardCount,
			String boardWriter, String nickName, String boardContent, String boardClass, String boardNotice,
			String status) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardDate = boardDate;
		this.boardHour = boardHour;
		this.boardMin = boardMin;
		this.boardCount = boardCount;
		this.boardWriter = boardWriter;
		this.nickName = nickName;
		this.boardContent = boardContent;
		this.boardClass = boardClass;
		this.boardNotice = boardNotice;
		this.status = status;
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

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardHour() {
		return boardHour;
	}

	public void setBoardHour(String boardHour) {
		this.boardHour = boardHour;
	}

	public String getBoardMin() {
		return boardMin;
	}

	public void setBoardMin(String boardMin) {
		this.boardMin = boardMin;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardClass() {
		return boardClass;
	}

	public void setBoardClass(String boardClass) {
		this.boardClass = boardClass;
	}

	public String getBoardNotice() {
		return boardNotice;
	}

	public void setBoardNotice(String boardNotice) {
		this.boardNotice = boardNotice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardDate=" + boardDate + ", boardHour="
				+ boardHour + ", boardMin=" + boardMin + ", boardCount=" + boardCount + ", boardWriter=" + boardWriter
				+ ", nickName=" + nickName + ", boardContent=" + boardContent + ", boardClass=" + boardClass
				+ ", boardNotice=" + boardNotice + ", status=" + status + "]";
	}
}
