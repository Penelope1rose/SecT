package model;

public class StudentInfoDetails {
	private int id;
	private String adminNo;
	private String ipAddr;
	private String portNo;
	private String timestamp;
	private String uniqueCode;
	private int submitDisable;
	private int cheating;
	private int disconnected;
	private String examCode;
	private int sskl;
	
	public StudentInfoDetails() {
		super();
	}

	public StudentInfoDetails(int id, String adminNo, String ipAddr, String portNo, String timestamp, String uniqueCode,
			int submitDisable, int cheating, int disconnected, String examCode, int sskl) {
		super();
		this.id = id;
		this.adminNo = adminNo;
		this.ipAddr = ipAddr;
		this.portNo = portNo;
		this.timestamp = timestamp;
		this.uniqueCode = uniqueCode;
		this.submitDisable = submitDisable;
		this.cheating = cheating;
		this.disconnected = disconnected;
		this.examCode = examCode;
		this.sskl = sskl;
	}

	public StudentInfoDetails(int id, String adminNo, String ipAddr, String portNo, String timestamp, String uniqueCode,
			int submitDisable, int cheating, int disconnected, int sskl) {
		super();
		this.id = id;
		this.adminNo = adminNo;
		this.ipAddr = ipAddr;
		this.portNo = portNo;
		this.timestamp = timestamp;
		this.uniqueCode = uniqueCode;
		this.submitDisable = submitDisable;
		this.cheating = cheating;
		this.disconnected = disconnected;
		this.sskl = sskl;
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

	public int getDisconnected() {
		return disconnected;
	}

	public void setDisconnected(int disconnected) {
		this.disconnected = disconnected;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public int getSskl() {
		return sskl;
	}

	public void setSskl(int sskl) {
		this.sskl = sskl;
	}

}
