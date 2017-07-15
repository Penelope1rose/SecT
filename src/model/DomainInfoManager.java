package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DBConnection;

public class DomainInfoManager {
	public static ArrayList<DomainInfoDetails> retrieveDomainInfo(int assessmentId) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_WHITELIST_DOMAIN WHERE C_ASSESSMENT_ID=?";
			
			ArrayList<DomainInfoDetails> DomainInfo = new ArrayList<DomainInfoDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, assessmentId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("C_ID");
				String domainName = rs.getString("C_DOMAIN_NAME");
				assessmentId = rs.getInt("C_ASSESSMENT_ID");
				String lecturerId = rs.getString("C_LECTURER_ID");

				DomainInfoDetails did = new DomainInfoDetails(id, domainName, assessmentId, lecturerId);
				DomainInfo.add(did);
			}
			conn.close();
			return DomainInfo; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static void insertDomainInfo(String domainName, int assessmentId, String lecturerId) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "INSERT INTO T_WHITELIST_DOMAIN(C_DOMAIN_NAME, C_ASSESSMENT_ID, C_LECTURER_ID) VALUES (?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, domainName);
			pstmt.setInt(2, assessmentId);
			pstmt.setString(3, lecturerId);
			
			pstmt.executeUpdate();

			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void deleteDomainInfo(int hiddenID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "DELETE FROM T_WHITELIST_DOMAIN WHERE C_ID=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hiddenID);
			
			pstmt.executeUpdate();

			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
