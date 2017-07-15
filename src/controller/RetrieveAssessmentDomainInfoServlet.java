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
 * Servlet implementation class RetrieveAssessmentDomainInfoServlet
 */
@WebServlet("/RetrieveAssessmentDomainInfoServlet")
public class RetrieveAssessmentDomainInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveAssessmentDomainInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		
		AssessmentInfoManager db = new AssessmentInfoManager();

		ArrayList<AssessmentInfoDetails> Assessment = db.retrieveStartAssessmentInfo(assessmentId);

		HttpSession session = request.getSession();
			
		session.setAttribute("dassessment", Assessment);
		response.sendRedirect("whitelistdomain.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
