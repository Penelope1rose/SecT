package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AssessmentInfoManager;

/**
 * Servlet implementation class DeleteAssessmentInfoServlet
 */
@WebServlet("/DeleteAssessmentInfoServlet")
public class DeleteAssessmentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAssessmentInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int hiddenID = Integer.parseInt(request.getParameter("hiddenID"));
		String staffID = request.getParameter("staffID");
		
		AssessmentInfoManager db = new AssessmentInfoManager();

		db.deleteAssessmentInfo(hiddenID);

		HttpSession session = request.getSession();
			
		response.sendRedirect("RetrieveUpdateAssessmentInfoServlet?staffID="+staffID);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
