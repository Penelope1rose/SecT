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
 * Servlet implementation class InsertAssessmentInfoServlet
 */
@WebServlet("/InsertAssessmentInfoServlet")
public class InsertAssessmentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAssessmentInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String modCode = request.getParameter("modCode");
		String modName = request.getParameter("modName");
		String staffID = request.getParameter("staffID");
		String assessmentName = request.getParameter("assessmentName");
		int period = Integer.parseInt(request.getParameter("period"));
		String datetime = request.getParameter("datetime");
		String examCode = request.getParameter("examCode");
		
		AssessmentInfoManager db = new AssessmentInfoManager();

		db.insertAssessmentInfo(modCode, modName, staffID, assessmentName, period, datetime, examCode);

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
