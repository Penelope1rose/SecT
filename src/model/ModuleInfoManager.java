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
				String modCode = rs.getString("C_MODULE_CODE");
				String modName = rs.getString("C_MODULE_NAME");

				ModuleInfoDetails mid = new ModuleInfoDetails(modCode, modName, staffID);
				ModuleInfo.add(mid);
			}
			conn.close();
			return ModuleInfo; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
