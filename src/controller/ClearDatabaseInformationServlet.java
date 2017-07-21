package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AnnouncementInfoManager;
import model.AssessmentInfoManager;
import model.DomainInfoManager;
import model.StudentInfoManager;
import model.StudentSubmissionInfoManager;

/**
 * Servlet implementation class ClearDatabaseInformationServlet
 */
@WebServlet("/ClearDatabaseInformationServlet")
public class ClearDatabaseInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClearDatabaseInformationServlet() {
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
		int assessmentID = Integer.parseInt(request.getParameter("assessmentID"));
		String staffID = request.getParameter("staffID");
		
		AssessmentInfoManager db = new AssessmentInfoManager();
		AnnouncementInfoManager db2 = new AnnouncementInfoManager();
		StudentInfoManager db3 = new StudentInfoManager();
		DomainInfoManager db4 = new DomainInfoManager();
		StudentSubmissionInfoManager db5 = new StudentSubmissionInfoManager();

		db.deleteAssessmentInfo(assessmentID);
		db2.clearAnnouncementInfo(assessmentID);
		db3.clearStudentInfo(assessmentID);
		db4.clearDomainInfo(assessmentID);
		db5.clearStudentSubmissionInfo(assessmentID);
			
		response.sendRedirect("RetrieveAllAssessmentInfoServlet?staffID="+staffID);
	}

}
