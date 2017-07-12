package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.*;

import model.LecturerInfoDetails;
import model.LecturerInfoManager;

/**
 * Servlet implementation class InsertLecturerInfoServlet
 */
@WebServlet("/InsertLecturerInfoServlet")
public class InsertLecturerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertLecturerInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String staffID = request.getParameter("staffID");
		String staffName = request.getParameter("staffName");
		String password = request.getParameter("password");
		String encryptedpass = null;
		
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
		       byte[] b = md.digest();
		       StringBuffer sb = new StringBuffer();
		       for(byte b1 : b){
		           sb.append(Integer.toHexString(b1 & 0xff).toString());
		       }
		       encryptedpass = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
		LecturerInfoManager db = new LecturerInfoManager();
		
		ArrayList<LecturerInfoDetails> lecturer = db.retrieveLecturerID(staffID);
		
		for(LecturerInfoDetails lecturerinfo:lecturer) {
			if (staffID.equalsIgnoreCase(lecturerinfo.getStaffNumber())) {
				HttpSession session = request.getSession();
				session.setAttribute("LECTURER_ID", "DUPLICATE");
				
				response.sendRedirect("signup.jsp");
				return;
			}
		}
		db.insertLecturerInfo(staffID, staffName, encryptedpass);
		response.sendRedirect("help.jsp");
	}

}
