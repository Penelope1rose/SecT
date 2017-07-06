package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import db.*;

public class StudentInfoManager{
	public static ArrayList<StudentInfoDetails> retrieveStudentInfo(String examCode) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_STUDENT_INFO WHERE C_EXAM_CODE=?";
			
			ArrayList<StudentInfoDetails> StudentInfo = new ArrayList<StudentInfoDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, examCode);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String adminNo = rs.getString("C_ADMISSION_NO");
				String ip = rs.getString("C_IP");
				String port = rs.getString("C_PORT");
				String timestamp = rs.getString("C_TIMESTAMP");
				String uniqueCode = rs.getString("C_UNIQUE_CODE");
				int submitDisable = rs.getInt("C_SUBMIT_DISABLE");
				int cheating = rs.getInt("C_CHEATING");
				int disconnected = rs.getInt("C_DISCONNECTED");

				StudentInfoDetails sid = new StudentInfoDetails(adminNo, ip, port, timestamp, uniqueCode, submitDisable, cheating, disconnected);
				StudentInfo.add(sid);
			}
			conn.close();
			return StudentInfo; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
