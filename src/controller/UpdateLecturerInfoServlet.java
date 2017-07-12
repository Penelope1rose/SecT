package controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LecturerInfoDetails;
import model.LecturerInfoManager;

/**
 * Servlet implementation class UpdateLecturerInfoServlet
 */
@WebServlet("/UpdateLecturerInfoServlet")
public class UpdateLecturerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLecturerInfoServlet() {
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
		String hiddenID = request.getParameter("hiddenID");
		String staffID = request.getParameter("staffID");
		String staffName = request.getParameter("staffName");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String encryptedpass = null;
		String encryptednewpass = null;
		
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(oldpassword.getBytes());
		       byte[] b1 = md.digest();
		       StringBuffer sb1 = new StringBuffer();
		       for(byte b : b1){
		           sb1.append(Integer.toHexString(b & 0xff).toString());
		       }
		       encryptedpass = sb1.toString();
		       
		       md.update(newpassword.getBytes());
		       byte[] b2 = md.digest();
		       StringBuffer sb2 = new StringBuffer();
		       for(byte b : b2){
		           sb2.append(Integer.toHexString(b & 0xff).toString());
		       }
		       encryptednewpass = sb2.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LecturerInfoManager db = new LecturerInfoManager();
		
		ArrayList<LecturerInfoDetails> lecturer = db.retrieveLecturerInfo(staffID, encryptedpass);
		
		HttpSession session = request.getSession();

		for(LecturerInfoDetails lecturerinfo:lecturer) {
			db.updateLecturerInfo(staffID, staffName, encryptednewpass, hiddenID);
			response.sendRedirect("index.jsp");
			return;
		}
		request.setAttribute("errorMessage", "Incorrect old password");
		request.getRequestDispatcher("editprofile.jsp").forward(request, response);
	}

}
