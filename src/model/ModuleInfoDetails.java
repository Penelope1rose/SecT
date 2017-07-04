package model;

public class ModuleInfoDetails {
	private String modCode;
	private String modName;
	private String staffID;
	
	public ModuleInfoDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModuleInfoDetails(String modCode, String modName, String staffID) {
		super();
		this.modCode = modCode;
		this.modName = modName;
		this.staffID = staffID;
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
