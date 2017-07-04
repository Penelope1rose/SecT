package model;

public class LecturerInfoDetails {
	private String staffNumber;
	private String staffName;
	private String password;
	
	public LecturerInfoDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LecturerInfoDetails(String staffNumber, String staffName, String password) {
		super();
		this.staffNumber = staffNumber;
		this.staffName = staffName;
		this.password = password;
	}

	public LecturerInfoDetails(String staffNumber, String staffName) {
		super();
		this.staffNumber = staffNumber;
		this.staffName = staffName;
	}

	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
