package model;

public class LecturerInfoDetails {
	private int id;
	private String staffNumber;
	private String staffName;
	private String password;
	
	public LecturerInfoDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LecturerInfoDetails(int id, String staffNumber, String staffName, String password) {
		super();
		this.id = id;
		this.staffNumber = staffNumber;
		this.staffName = staffName;
		this.password = password;
	}

	public LecturerInfoDetails(String staffNumber, String staffName) {
		super();
		this.staffNumber = staffNumber;
		this.staffName = staffName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
