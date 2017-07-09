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
			
			String sql = "SELECT * FROM T_ANNOUNCEMENT WHERE C_LECTURER_ID=? ORDER BY C_MODULE_CODE, TIME(C_TIMESTAMP) DESC";
			
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
				String examCode = rs.getString("C_EXAM_CODE");

				AnnouncementInfoDetails ad = new AnnouncementInfoDetails(moduleCode, lecturerId, lecturerName, announcement, timestamp, examCode);
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
			
			String sql = "SELECT * FROM T_ANNOUNCEMENT WHERE C_LECTURER_ID=? AND C_MODULE_CODE=? ORDER BY TIME(C_TIMESTAMP) DESC";
			
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
				String examCode = rs.getString("C_EXAM_CODE");

				AnnouncementInfoDetails ad = new AnnouncementInfoDetails(moduleCode, lecturerId, lecturerName, announcement, timestamp, examCode);
				Announcement.add(ad);
			}
			conn.close();
			return Announcement; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
}
