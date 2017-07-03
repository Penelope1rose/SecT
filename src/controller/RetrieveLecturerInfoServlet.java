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
 * Servlet implementation class RetrieveLecturerInfoServlet
 */
@WebServlet("/RetrieveLecturerInfoServlet")
public class RetrieveLecturerInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveLecturerInfoServlet() {
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
		String password = request.getParameter("password");
		
		LecturerInfoManager db = new LecturerInfoManager();

		ArrayList<LecturerInfoDetails> lecturer = db.retrieveLecturerInfo(staffID, password);

		for(LecturerInfoDetails lecturerinfo:lecturer) {
			HttpSession session = request.getSession();
			session.setAttribute("lecturer", lecturer);
			
			response.sendRedirect("home.jsp");
			return;
		}
		response.sendRedirect("index.html");
		
	}

}
