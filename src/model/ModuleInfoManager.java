package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DBConnection;

public class ModuleInfoManager {
	public static ArrayList<ModuleInfoDetails> retrieveModuleInfo(String staffID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "SELECT * FROM T_MODULE WHERE C_LECTURER_ID=?";
			
			ArrayList<ModuleInfoDetails> ModuleInfo = new ArrayList<ModuleInfoDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, staffID);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("C_ID");
				String modCode = rs.getString("C_MODULE_CODE");
				String modName = rs.getString("C_MODULE_NAME");

				ModuleInfoDetails mid = new ModuleInfoDetails(id, modCode, modName, staffID);
				ModuleInfo.add(mid);
			}
			conn.close();
			return ModuleInfo; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static void insertModuleInfo(String modCode, String modName, String staffID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "INSERT INTO T_MODULE(C_MODULE_CODE, C_MODULE_NAME, C_LECTURER_ID) VALUES (?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modCode);
			pstmt.setString(2, modName);
			pstmt.setString(3, staffID);
			
			pstmt.executeUpdate();

			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void deleteModuleInfo(int hiddenID) {
		try {	
			Connection conn = DBConnection.getConnection();
			
			String sql = "DELETE FROM T_MODULE WHERE C_ID=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hiddenID);
			
			pstmt.executeUpdate();

			conn.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
