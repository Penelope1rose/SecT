package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AssessmentInfoDetails;
import model.AssessmentInfoManager;

/**
 * Servlet implementation class RetrieveAssessmentInfoServlet
 */
@WebServlet("/RetrieveAssessmentInfoServlet")
public class RetrieveAssessmentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveAssessmentInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String staffID = request.getParameter("staffID");
		
		AssessmentInfoManager db = new AssessmentInfoManager();

		ArrayList<AssessmentInfoDetails> Assessment = db.retrieveAssessmentInfo(staffID);

		HttpSession session = request.getSession();
		
		session.setAttribute("assessment", Assessment);
		response.sendRedirect("RetrieveAllAnnouncementInfoServlet?staffID="+staffID);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
