package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import db.*;

public class StudentInfoManager{
	public static ArrayList<StudentInfoDetails> retrieveStudentInfo(int assessmentId) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_STUDENT_INFO WHERE C_ASSESSMENT_ID=?";
			
			ArrayList<StudentInfoDetails> StudentInfo = new ArrayList<StudentInfoDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, assessmentId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("C_ID");
				String adminNo = rs.getString("C_ADMISSION_NO");
				String ip = rs.getString("C_IP");
				String port = rs.getString("C_PORT");
				String timestamp = rs.getString("C_TIMESTAMP");
				String uniqueCode = rs.getString("C_UNIQUE_CODE");
				int submitDisable = rs.getInt("C_SUBMIT_DISABLE");
				int cheating = rs.getInt("C_CHEATING");
				int disconnected = rs.getInt("C_DISCONNECTED");
				int sskl = rs.getInt("C_SS_KL");

				StudentInfoDetails sid = new StudentInfoDetails(id, adminNo, ip, port, timestamp, uniqueCode, submitDisable, cheating, disconnected, sskl);
				StudentInfo.add(sid);
			}
			conn.close();
			return StudentInfo; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static void deleteStudentInfo(String hiddenID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "DELETE FROM T_STUDENT_INFO WHERE C_ID=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hiddenID);
			
			pstmt.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void updateStartSSKLStudentInfo(String hiddenID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "UPDATE T_STUDENT_INFO SET C_SS_KL=1 WHERE C_ID=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hiddenID);
			
			pstmt.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void updateStopSSKLStudentInfo(String hiddenID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "UPDATE T_STUDENT_INFO SET C_SS_KL=0 WHERE C_ID=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hiddenID);
			
			pstmt.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void deleteAllStudentInfo(int assessmentId) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "DELETE FROM T_STUDENT_INFO WHERE C_ASSESSMENT_ID=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, assessmentId);
			
			pstmt.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
