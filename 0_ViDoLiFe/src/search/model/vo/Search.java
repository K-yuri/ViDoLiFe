package search.model.vo;

public class Search {
	
	private int conNo;
	private String conTitle;
	private String conGenre;
	private String conActor;
	private String conType;
	private String conSummary;
	private String conPicOriginName;
	private String conPicNewName;
	private String conPicPath;
	
	public Search() {}

	public Search(int conNo, String conTitle, String conGenre, String conActor, String conType, String conSummary,
			String conPicOriginName, String conPicNewName, String conPicPath) {
		super();
		this.conNo = conNo;
		this.conTitle = conTitle;
		this.conGenre = conGenre;
		this.conActor = conActor;
		this.conType = conType;
		this.conSummary = conSummary;
		this.conPicOriginName = conPicOriginName;
		this.conPicNewName = conPicNewName;
		this.conPicPath = conPicPath;
	}

	public int getConNo() {
		return conNo;
	}

	public void setConNo(int conNo) {
		this.conNo = conNo;
	}

	public String getConTitle() {
		return conTitle;
	}

	public void setConTitle(String conTitle) {
		this.conTitle = conTitle;
	}

	public String getConGenre() {
		return conGenre;
	}

	public void setConGenre(String conGenre) {
		this.conGenre = conGenre;
	}

	public String getConActor() {
		return conActor;
	}

	public void setConActor(String conActor) {
		this.conActor = conActor;
	}

	public String getConType() {
		return conType;
	}

	public void setConType(String conType) {
		this.conType = conType;
	}

	public String getConSummary() {
		return conSummary;
	}

	public void setConSummary(String conSummary) {
		this.conSummary = conSummary;
	}

	public String getConPicOriginName() {
		return conPicOriginName;
	}

	public void setConPicOriginName(String conPicOriginName) {
		this.conPicOriginName = conPicOriginName;
	}

	public String getConPicNewName() {
		return conPicNewName;
	}

	public void setConPicNewName(String conPicNewName) {
		this.conPicNewName = conPicNewName;
	}

	public String getConPicPath() {
		return conPicPath;
	}

	public void setConPicPath(String conPicPath) {
		this.conPicPath = conPicPath;
	}

	@Override
	public String toString() {
		return "Search [conNo=" + conNo + ", conTitle=" + conTitle + ", conGenre=" + conGenre + ", conActor=" + conActor
				+ ", conType=" + conType + ", conSummary=" + conSummary + ", conPicOriginName=" + conPicOriginName
				+ ", conPicNewName=" + conPicNewName + ", conPicPath=" + conPicPath + "]";
	}

}
