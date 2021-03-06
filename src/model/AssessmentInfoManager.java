package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.*;

public class AssessmentInfoManager {
	public static ArrayList<AssessmentInfoDetails> retrieveAssessmentInfo(String staffID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_ASSESSMENT WHERE C_LECTURER_ID=? AND C_STARTED=0";
			
			ArrayList<AssessmentInfoDetails> Assessment = new ArrayList<AssessmentInfoDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, staffID);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("C_ID");
				String moduleCode = rs.getString("C_MODULE_CODE");
				String moduleName = rs.getString("C_MODULE_NAME");
				String lecturerID = rs.getString("C_LECTURER_ID");
				String assessmentName = rs.getString("C_ASSESSMENT_NAME");
				int period = rs.getInt("C_PERIOD");
				String datetime = rs.getString("C_DATETIME");
				String examCode = rs.getString("C_EXAM_CODE");
				int started = rs.getInt("C_STARTED");

				AssessmentInfoDetails aid = new AssessmentInfoDetails(id, moduleCode, moduleName, lecturerID, assessmentName, period, datetime, examCode, started);
				Assessment.add(aid);
			}
			conn.close();
			return Assessment; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static ArrayList<AssessmentInfoDetails> retrieveAllAssessmentInfo(String staffID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_ASSESSMENT WHERE C_LECTURER_ID=? ORDER BY C_DATETIME DESC";
			
			ArrayList<AssessmentInfoDetails> Assessment = new ArrayList<AssessmentInfoDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, staffID);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("C_ID");
				String moduleCode = rs.getString("C_MODULE_CODE");
				String moduleName = rs.getString("C_MODULE_NAME");
				String lecturerID = rs.getString("C_LECTURER_ID");
				String assessmentName = rs.getString("C_ASSESSMENT_NAME");
				int period = rs.getInt("C_PERIOD");
				String datetime = rs.getString("C_DATETIME");
				String examCode = rs.getString("C_EXAM_CODE");
				int started = rs.getInt("C_STARTED");

				AssessmentInfoDetails aid = new AssessmentInfoDetails(id, moduleCode, moduleName, lecturerID, assessmentName, period, datetime, examCode, started);
				Assessment.add(aid);
			}
			conn.close();
			return Assessment; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static void deleteAssessmentInfo(int hiddenID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "DELETE FROM T_ASSESSMENT WHERE C_ID=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hiddenID);
			
			pstmt.executeUpdate();

			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void insertAssessmentInfo(String modCode, String modName, String staffID, String assessmentName, int period, String datetime, String examCode) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "INSERT INTO T_ASSESSMENT(C_MODULE_CODE, C_MODULE_NAME, C_LECTURER_ID, C_ASSESSMENT_NAME, C_PERIOD, C_DATETIME, C_EXAM_CODE, C_STARTED) VALUES (?, ?, ?, ?, ?, ?, ?, 0)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modCode);
			pstmt.setString(2, modName);
			pstmt.setString(3, staffID);
			pstmt.setString(4, assessmentName);
			pstmt.setInt(5, period);
			pstmt.setString(6, datetime);
			pstmt.setString(7, examCode);
			
			pstmt.executeUpdate();

			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static ArrayList<AssessmentInfoDetails> retrieveStartAssessmentInfo(int hiddenID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_ASSESSMENT WHERE C_ID=? AND C_STARTED=0";
			
			ArrayList<AssessmentInfoDetails> startAssessment = new ArrayList<AssessmentInfoDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hiddenID);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("C_ID");
				String moduleCode = rs.getString("C_MODULE_CODE");
				String moduleName = rs.getString("C_MODULE_NAME");
				String lecturerID = rs.getString("C_LECTURER_ID");
				String assessmentName = rs.getString("C_ASSESSMENT_NAME");
				int period = rs.getInt("C_PERIOD");
				String datetime = rs.getString("C_DATETIME");
				String examCode = rs.getString("C_EXAM_CODE");
				int started = rs.getInt("C_STARTED");

				AssessmentInfoDetails said = new AssessmentInfoDetails(id, moduleCode, moduleName, lecturerID, assessmentName, period, datetime, examCode, started);
				startAssessment.add(said);
			}
			conn.close();
			return startAssessment; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static void updateAssessmentInfo(String hiddenID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "UPDATE T_ASSESSMENT SET C_STARTED=1 WHERE C_ID=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hiddenID);
			
			pstmt.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static ArrayList<AssessmentInfoDetails> retrieveAssessmentInfo(int hiddenID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_ASSESSMENT WHERE C_ID=?";
			
			ArrayList<AssessmentInfoDetails> startAssessment = new ArrayList<AssessmentInfoDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hiddenID);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("C_ID");
				String moduleCode = rs.getString("C_MODULE_CODE");
				String moduleName = rs.getString("C_MODULE_NAME");
				String lecturerID = rs.getString("C_LECTURER_ID");
				String assessmentName = rs.getString("C_ASSESSMENT_NAME");
				int period = rs.getInt("C_PERIOD");
				String datetime = rs.getString("C_DATETIME");
				String examCode = rs.getString("C_EXAM_CODE");
				int started = rs.getInt("C_STARTED");

				AssessmentInfoDetails said = new AssessmentInfoDetails(id, moduleCode, moduleName, lecturerID, assessmentName, period, datetime, examCode, started);
				startAssessment.add(said);
			}
			conn.close();
			return startAssessment; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
