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
				String lecturerName = rs.getString("C_LECTURER_NAME");

				LecturerInfoDetails lid = new LecturerInfoDetails(lecturerName);
				LecturerInfo.add(lid);
			}
			conn.close();
			return LecturerInfo; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
