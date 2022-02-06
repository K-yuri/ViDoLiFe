package member.model.vo;

public class Subscribe {

	private int subNo;
	private String fromUser;
	private String toUser;
	private String toUserNick;
	private String toUserPicNew;
	private String toUserPicPath;
	
	public Subscribe() {}

	public Subscribe(int subNo, String fromUser, String toUser, String toUserNick, String toUserPicNew,
			String toUserPicPath) {
		super();
		this.subNo = subNo;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.toUserNick = toUserNick;
		this.toUserPicNew = toUserPicNew;
		this.toUserPicPath = toUserPicPath;
	}

	public int getSubNo() {
		return subNo;
	}

	public void setSubNo(int subNo) {
		this.subNo = subNo;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getToUserNick() {
		return toUserNick;
	}

	public void setToUserNick(String toUserNick) {
		this.toUserNick = toUserNick;
	}

	public String getToUserPicNew() {
		return toUserPicNew;
	}

	public void setToUserPicNew(String toUserPicNew) {
		this.toUserPicNew = toUserPicNew;
	}

	public String getToUserPicPath() {
		return toUserPicPath;
	}

	public void setToUserPicPath(String toUserPicPath) {
		this.toUserPicPath = toUserPicPath;
	}

	@Override
	public String toString() {
		return "Subscribe [subNo=" + subNo + ", fromUser=" + fromUser + ", toUser=" + toUser + ", toUserNick="
				+ toUserNick + ", toUserPicNew=" + toUserPicNew + ", toUserPicPath=" + toUserPicPath + "]";
	}

}
