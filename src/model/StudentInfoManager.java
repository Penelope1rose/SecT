package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import db.*;

public class StudentInfoManager{
	public static ArrayList<StudentInfoDetails> retrieveTimestamp() {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT C_TIMESTAMP FROM T_STUDENT_INFO";
			
			ArrayList<StudentInfoDetails> StudentInfo = new ArrayList<StudentInfoDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String timestamp = rs.getString("C_TIMESTAMP");

				StudentInfoDetails sid = new StudentInfoDetails(timestamp);
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
