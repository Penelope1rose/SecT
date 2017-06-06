package model;

public class StudentInfoDetails {
	private String adminNo;
	private String ipAddr;
	private String portNo;
	private String timestamp;
	private String uniqueCode;
	private int submitDisable;
	private int cheating;
	
	public StudentInfoDetails() {
		super();
	}
	
	public StudentInfoDetails(String adminNo, String ipAddr, String portNo, String timestamp, String uniqueCode,
			int submitDisable, int cheating) {
		super();
		this.adminNo = adminNo;
		this.ipAddr = ipAddr;
		this.portNo = portNo;
		this.timestamp = timestamp;
		this.uniqueCode = uniqueCode;
		this.submitDisable = submitDisable;
		this.cheating = cheating;
	}

	public StudentInfoDetails(String timestamp) {
		super();
		this.timestamp = timestamp;
	}

	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getPortNo() {
		return portNo;
	}

	public void setPortNo(String portNo) {
		this.portNo = portNo;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	public int getSubmitDisable() {
		return submitDisable;
	}

	public void setSubmitDisable(int submitDisable) {
		this.submitDisable = submitDisable;
	}

	public int getCheating() {
		return cheating;
	}

	public void setCheating(int cheating) {
		this.cheating = cheating;
	}

}
