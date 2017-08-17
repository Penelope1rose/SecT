package model;

public class StudentInfoDetails {
	private int id;
	private String adminNo;
	private int tableNo;
	private String ipAddr;
	private String portNo;
	private String timestamp;
	private String uniqueCode;
	private int cheating;
	private int disconnected;
	private int assessmentId;
	private int sskl;
	private int login;
	private String fileName;
	private int version;
	
	public StudentInfoDetails() {
		super();
	}

	public StudentInfoDetails(int id, String adminNo, int tableNo, String ipAddr, String portNo, String timestamp, String uniqueCode,
			int cheating, int disconnected, int assessmentId, int sskl, int login, String fileName, int version) {
		super();
		this.id = id;
		this.adminNo = adminNo;
		this.tableNo = tableNo;
		this.ipAddr = ipAddr;
		this.portNo = portNo;
		this.timestamp = timestamp;
		this.uniqueCode = uniqueCode;
		this.cheating = cheating;
		this.disconnected = disconnected;
		this.assessmentId = assessmentId;
		this.sskl = sskl;
		this.login = login;
		this.fileName = fileName;
		this.version = version;
	}
	
	public StudentInfoDetails(int id, String adminNo, int tableNo, String ipAddr, String portNo, String timestamp, String uniqueCode,
			int cheating, int disconnected, int sskl, int login, String fileName, int version) {
		super();
		this.id = id;
		this.adminNo = adminNo;
		this.tableNo = tableNo;
		this.ipAddr = ipAddr;
		this.portNo = portNo;
		this.timestamp = timestamp;
		this.uniqueCode = uniqueCode;
		this.cheating = cheating;
		this.disconnected = disconnected;
		this.sskl = sskl;
		this.login = login;
		this.fileName = fileName;
		this.version = version;
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

	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
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

	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

	public int getSskl() {
		return sskl;
	}

	public void setSskl(int sskl) {
		this.sskl = sskl;
	}
	
	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
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

}
