package member.model.vo;

public class Member {
	private String userId;
	private String userPwd;
	private String userName;
	private String userNick;
	private String userEmail;
	private String userProfileMsg;
	private String userPicOrigin;
	private String userPicNew;
	private String userPicPath;
	private String userAdmin;
	private String status;
	
	public Member() {}

	public Member(String userId, String userPwd, String userName, String userNick, String userEmail,
			String userProfileMsg, String userPicOrigin, String userPicNew, String userPicPath, String userAdmin,
			String status) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userNick = userNick;
		this.userEmail = userEmail;
		this.userProfileMsg = userProfileMsg;
		this.userPicOrigin = userPicOrigin;
		this.userPicNew = userPicNew;
		this.userPicPath = userPicPath;
		this.userAdmin = userAdmin;
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserProfileMsg() {
		return userProfileMsg;
	}

	public void setUserProfileMsg(String userProfileMsg) {
		this.userProfileMsg = userProfileMsg;
	}

	public String getUserPicOrigin() {
		return userPicOrigin;
	}

	public void setUserPicOrigin(String userPicOrigin) {
		this.userPicOrigin = userPicOrigin;
	}

	public String getUserPicNew() {
		return userPicNew;
	}

	public void setUserPicNew(String userPicNew) {
		this.userPicNew = userPicNew;
	}

	public String getUserPicPath() {
		return userPicPath;
	}

	public void setUserPicPath(String userPicPath) {
		this.userPicPath = userPicPath;
	}

	public String getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(String userAdmin) {
		this.userAdmin = userAdmin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userNick=" + userNick
				+ ", userEmail=" + userEmail + ", userProfileMsg=" + userProfileMsg + ", userPicOrigin=" + userPicOrigin
				+ ", userPicNew=" + userPicNew + ", userPicPath=" + userPicPath + ", userAdmin=" + userAdmin
				+ ", status=" + status + "]";
	}
	
}
