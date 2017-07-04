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
			
			String sql = "SELECT * FROM T_ASSESSMENT WHERE C_LECTURER_ID=?";
			
			ArrayList<AssessmentInfoDetails> Assessment = new ArrayList<AssessmentInfoDetails>();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, staffID);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String moduleCode = rs.getString("C_MODULE_CODE");
				String moduleName = rs.getString("C_MODULE_NAME");
				String assessmentName = rs.getString("C_ASSESSMENT_NAME");
				int period = rs.getInt("C_PERIOD");
				String datetime = rs.getString("C_DATETIME");
				String examCode = rs.getString("C_EXAM_CODE");

				AssessmentInfoDetails aid = new AssessmentInfoDetails(moduleCode, moduleName, assessmentName, period, datetime, examCode);
				Assessment.add(aid);
			}
			conn.close();
			return Assessment; 
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
