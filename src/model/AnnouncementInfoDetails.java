package model;

import java.sql.Timestamp;

public class AnnouncementInfoDetails {
	private String moduleCode;
	private String lecturerId;
	private String lecturerName;
	private String announcement;
	private Timestamp timestamp;
	private int assessmentId;
	
	public AnnouncementInfoDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnnouncementInfoDetails(String moduleCode, String lecturerId, String lecturerName, String announcement, Timestamp timestamp,
			int assessmentId) {
		super();
		this.moduleCode = moduleCode;
		this.lecturerId = lecturerId;
		this.lecturerName = lecturerName;
		this.announcement = announcement;
		this.timestamp = timestamp;
		this.assessmentId = assessmentId;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(String lecturerId) {
		this.lecturerId = lecturerId;
	}

	public String getLecturerName() {
		return lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public String getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}
	
}
