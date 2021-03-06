package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import db.*;

public class AnnouncementInfoManager{
	public static ArrayList<AnnouncementInfoDetails> retrieveAllAnnouncement(String staffID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_ANNOUNCEMENT WHERE C_LECTURER_ID=? ORDER BY C_TIMESTAMP DESC";
			
			ArrayList<AnnouncementInfoDetails> Announcement = new ArrayList<AnnouncementInfoDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, staffID);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String moduleCode = rs.getString("C_MODULE_CODE");
				String lecturerId = rs.getString("C_LECTURER_ID");
				String lecturerName = rs.getString("C_LECTURER_NAME");
				String announcement = rs.getString("C_ANNOUNCEMENT");
				Timestamp timestamp = rs.getTimestamp("C_TIMESTAMP");
				int assessmentId = rs.getInt("C_ASSESSMENT_ID");

				AnnouncementInfoDetails ad = new AnnouncementInfoDetails(moduleCode, lecturerId, lecturerName, announcement, timestamp, assessmentId);
				Announcement.add(ad);
			}
			conn.close();
			return Announcement; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static ArrayList<AnnouncementInfoDetails> retrieveAnnouncement(String staffID, String modCode) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_ANNOUNCEMENT WHERE C_LECTURER_ID=? AND C_MODULE_CODE=? ORDER BY C_TIMESTAMP DESC";
			
			ArrayList<AnnouncementInfoDetails> Announcement = new ArrayList<AnnouncementInfoDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, staffID);
			pstmt.setString(2, modCode);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String moduleCode = rs.getString("C_MODULE_CODE");
				String lecturerId = rs.getString("C_LECTURER_ID");
				String lecturerName = rs.getString("C_LECTURER_NAME");
				String announcement = rs.getString("C_ANNOUNCEMENT");
				Timestamp timestamp = rs.getTimestamp("C_TIMESTAMP");
				int assessmentId = rs.getInt("C_ASSESSMENT_ID");

				AnnouncementInfoDetails ad = new AnnouncementInfoDetails(moduleCode, lecturerId, lecturerName, announcement, timestamp, assessmentId);
				Announcement.add(ad);
			}
			conn.close();
			return Announcement; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static void insertAnnouncementInfo(String modCode, String staffID, String staffName, String announcement) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "INSERT INTO T_ANNOUNCEMENT(C_MODULE_CODE, C_LECTURER_ID, C_LECTURER_NAME, C_ANNOUNCEMENT, C_TIMESTAMP, C_ASSESSMENT_ID) VALUES (?, ?, ?, ?, now(), (SELECT C_ID FROM T_ASSESSMENT WHERE C_MODULE_CODE=? AND C_STARTED=0))";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modCode);
			pstmt.setString(2, staffID);
			pstmt.setString(3, staffName);
			pstmt.setString(4, announcement);
			pstmt.setString(5, modCode);

			pstmt.executeUpdate();

			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void clearAnnouncementInfo(int assessmentID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "DELETE FROM T_ANNOUNCEMENT WHERE C_ASSESSMENT_ID=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, assessmentID);
			
			pstmt.executeUpdate();

			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
