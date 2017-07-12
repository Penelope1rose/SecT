package model;

public class ModuleInfoDetails {
	private int id;
	private String modCode;
	private String modName;
	private String staffID;
	
	public ModuleInfoDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModuleInfoDetails(int id, String modCode, String modName, String staffID) {
		super();
		this.id = id;
		this.modCode = modCode;
		this.modName = modName;
		this.staffID = staffID;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModCode() {
		return modCode;
	}

	public void setModCode(String modCode) {
		this.modCode = modCode;
	}

	public String getModName() {
		return modName;
	}

	public void setModName(String modName) {
		this.modName = modName;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

}
