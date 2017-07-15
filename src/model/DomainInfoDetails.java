package model;

public class DomainInfoDetails {
	private int id;
	private String domainName;
	private int assessmentId;
	private String lecturerId;
	
	public DomainInfoDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DomainInfoDetails(int id, String domainName, int assessmentId, String lecturerId) {
		super();
		this.id = id;
		this.domainName = domainName;
		this.assessmentId = assessmentId;
		this.lecturerId = lecturerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(String lecturerId) {
		this.lecturerId = lecturerId;
	}
	
}
