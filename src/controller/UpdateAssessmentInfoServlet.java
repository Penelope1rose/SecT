package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AssessmentInfoManager;

/**
 * Servlet implementation class UpdateAssessmentInfoServlet
 */
@WebServlet("/UpdateAssessmentInfoServlet")
public class UpdateAssessmentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAssessmentInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hiddenID = request.getParameter("hiddenID");
		String staffID = request.getParameter("staffID");
		
		AssessmentInfoManager db = new AssessmentInfoManager();

		db.updateAssessmentInfo(hiddenID);

		response.sendRedirect("RetrieveAssessmentInfoServlet?staffID="+staffID);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
