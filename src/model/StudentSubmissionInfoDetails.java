package model;

public class StudentSubmissionInfoDetails {
	private int id;
	private String adminNo;
	private String uniqueCode;
	private String fileName;
	private int version;
	private int assessmentId;
	
	public StudentSubmissionInfoDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentSubmissionInfoDetails(int id, String adminNo, String uniqueCode, String fileName, int version,
			int assessmentId) {
		super();
		this.id = id;
		this.adminNo = adminNo;
		this.uniqueCode = uniqueCode;
		this.fileName = fileName;
		this.version = version;
		this.assessmentId = assessmentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

}
