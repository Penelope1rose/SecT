package controller;

import java.io.IOException;
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
		
		LecturerInfoManager db = new LecturerInfoManager();
		
		ArrayList<LecturerInfoDetails> lecturer = db.retrieveLecturerInfo(staffID, oldpassword);
		
		HttpSession session = request.getSession();

		for(LecturerInfoDetails lecturerinfo:lecturer) {
			db.updateLecturerInfo(staffID, staffName, newpassword, hiddenID);
			response.sendRedirect("index.jsp");
			return;
		}
		request.setAttribute("errorMessage", "Incorrect old password");
		request.getRequestDispatcher("editprofile.jsp").forward(request, response);
	}

}
