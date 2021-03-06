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
import model.LecturerInfoDetails;

/**
 * Servlet implementation class RetrieveStartAssessmentInfoServlet
 */
@WebServlet("/RetrieveStartAssessmentInfoServlet")
public class RetrieveStartAssessmentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveStartAssessmentInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int hiddenID = Integer.parseInt(request.getParameter("hiddenID"));
		
		AssessmentInfoManager db = new AssessmentInfoManager();

		ArrayList<AssessmentInfoDetails> startAssessment = db.retrieveStartAssessmentInfo(hiddenID);

		HttpSession session = request.getSession();
		
		session.removeAttribute("REFRESH");
		session.setAttribute("startassessment", startAssessment);
		response.sendRedirect("RetrieveStudentInfoServlet?assessmentId="+hiddenID);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
