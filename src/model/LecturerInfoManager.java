package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DBConnection;

public class LecturerInfoManager {
	public static ArrayList<LecturerInfoDetails> retrieveLecturerInfo(String staffNumber, String password) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_LECTURER_INFO WHERE C_LECTURER_ID=? AND C_PASSWORD=?";
			
			ArrayList<LecturerInfoDetails> LecturerInfo = new ArrayList<LecturerInfoDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, staffNumber);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("C_ID");
				String lecturerID = rs.getString("C_LECTURER_ID");
				String lecturerName = rs.getString("C_LECTURER_NAME");
				password = rs.getString("C_PASSWORD");

				LecturerInfoDetails lid = new LecturerInfoDetails(id, lecturerID, lecturerName, password);
				LecturerInfo.add(lid);
			}
			conn.close();
			return LecturerInfo; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static ArrayList<LecturerInfoDetails> retrieveLecturerID(String staffNumber) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_LECTURER_INFO WHERE C_LECTURER_ID=?";
			
			ArrayList<LecturerInfoDetails> LecturerInfo = new ArrayList<LecturerInfoDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, staffNumber);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String lecturerID = rs.getString("C_LECTURER_ID");
				String lecturerName = rs.getString("C_LECTURER_NAME");

				LecturerInfoDetails lid = new LecturerInfoDetails(lecturerID, lecturerName);
				LecturerInfo.add(lid);
			}
			conn.close();
			return LecturerInfo; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static void insertLecturerInfo(String staffID, String staffNumber, String password) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "INSERT INTO T_LECTURER_INFO(C_LECTURER_ID, C_LECTURER_NAME, C_PASSWORD) VALUES (?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, staffID);
			pstmt.setString(2, staffNumber);
			pstmt.setString(3, password);
			
			pstmt.executeUpdate();

			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void updateLecturerInfo(String staffID, String staffName, String password, String hiddenID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "UPDATE T_LECTURER_INFO SET C_LECTURER_ID=?, C_LECTURER_NAME=?, C_PASSWORD=? WHERE C_ID=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, staffID);
			pstmt.setString(2, staffName);
			pstmt.setString(3, password);
			pstmt.setString(4, hiddenID);
			
			pstmt.executeUpdate();
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
