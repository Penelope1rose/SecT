package model;

public class AssessmentInfoDetails {
	private int id;
	private String moduleCode;
	private String moduleName;
	private String lecturerID;
	private String assessmentName;
	private int period;
	private String datetime;
	private String examCode;
	
	public AssessmentInfoDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssessmentInfoDetails(int id, String moduleCode, String moduleName, String lecturerID, String assessmentName, int period, String datetime,
			String examCode) {
		super();
		this.id = id;
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		this.lecturerID = lecturerID;
		this.assessmentName = assessmentName;
		this.period = period;
		this.datetime = datetime;
		this.examCode = examCode;
	}

	public AssessmentInfoDetails(int id, String moduleCode, String moduleName, String assessmentName, int period, String datetime, String examCode) {
		super();
		this.id = id;
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		this.assessmentName = assessmentName;
		this.period = period;
		this.datetime = datetime;
		this.examCode = examCode;
	}

	public AssessmentInfoDetails(String moduleCode, String moduleName, String lecturerID, String assessmentName,
			int period, String datetime, String examCode) {
		super();
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		this.lecturerID = lecturerID;
		this.assessmentName = assessmentName;
		this.period = period;
		this.datetime = datetime;
		this.examCode = examCode;
	}

	public AssessmentInfoDetails(String moduleCode, String moduleName, String assessmentName, int period,
			String datetime, String examCode) {
		super();
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		this.assessmentName = assessmentName;
		this.period = period;
		this.datetime = datetime;
		this.examCode = examCode;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getLecturerID() {
		return lecturerID;
	}

	public void setLecturerID(String lecturerID) {
		this.lecturerID = lecturerID;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
