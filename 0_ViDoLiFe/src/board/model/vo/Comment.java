package board.model.vo;

import java.sql.Date;

public class Comment {
	private int commentNo;			// 댓글 번호
	private String commentContent;	// 댓글 내용
	private int commentBNo;			// 댓글이 달린 게시글 번호
	private Date commentDate;		// 댓글 작성 날짜
	private String commentHour;		// 댓글 작성 시
	private String commentMin;		// 댓글 작성 분
	private String commentWriter;	// 댓글 작성자
	private String nickName;		// 댓글 작성자 닉네임
	private String status;			// 상태
	
	public Comment() {}
	
	public Comment(int commentNo, String commentContent, int commentBNo, Date commentDate, String commentHour,
			String commentMin, String commentWriter, String nickName, String status) {
		super();
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.commentBNo = commentBNo;
		this.commentDate = commentDate;
		this.commentHour = commentHour;
		this.commentMin = commentMin;
		this.commentWriter = commentWriter;
		this.nickName = nickName;
		this.status = status;
	}
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public int getCommentBNo() {
		return commentBNo;
	}
	public void setCommentBNo(int commentBNo) {
		this.commentBNo = commentBNo;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentHour() {
		return commentHour;
	}
	public void setCommentHour(String commentHour) {
		this.commentHour = commentHour;
	}
	public String getCommentMin() {
		return commentMin;
	}
	public void setCommentMin(String commentMin) {
		this.commentMin = commentMin;
	}
	public String getCommentWriter() {
		return commentWriter;
	}
	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Reply [commentNo=" + commentNo + ", commentContent=" + commentContent + ", commentBNo=" + commentBNo
				+ ", commentDate=" + commentDate + ", commentHour=" + commentHour + ", commentMin=" + commentMin
				+ ", commentWriter=" + commentWriter + ", nickName=" + nickName + ", status=" + status + "]";
	}
	
	
}
