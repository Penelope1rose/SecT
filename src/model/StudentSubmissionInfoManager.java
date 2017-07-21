package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DBConnection;

public class StudentSubmissionInfoManager {
	
	public static void clearStudentSubmissionInfo(int assessmentID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "DELETE FROM T_STUDENT_SUBMISSION WHERE C_ASSESSMENT_ID=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, assessmentID);
			
			pstmt.executeUpdate();

			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static ArrayList<StudentSubmissionInfoDetails> retrieveStudentSubmissionInfo(int assessmentId) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_STUDENT_SUBMISSION WHERE C_ASSESSMENT_ID=?";
			
			ArrayList<StudentSubmissionInfoDetails> StudentSubInfo = new ArrayList<StudentSubmissionInfoDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, assessmentId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("C_ID");
				String adminNo = rs.getString("C_ADMISSION_NO");
				String uniqueCode = rs.getString("C_UNIQUE_CODE");
				String fileName = rs.getString("C_FILE_NAME");
				int version = rs.getInt("C_VERSION");
				assessmentId = rs.getInt("C_ASSESSMENT_ID");

				StudentSubmissionInfoDetails ssid = new StudentSubmissionInfoDetails(id, adminNo, uniqueCode, fileName, version, assessmentId);
				StudentSubInfo.add(ssid);
			}
			conn.close();
			return StudentSubInfo; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
