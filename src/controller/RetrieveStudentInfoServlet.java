package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LecturerInfoDetails;
import model.StudentInfoDetails;
import model.StudentInfoManager;

/**
 * Servlet implementation class RetrieveStudentInfoServlet
 */
@WebServlet("/RetrieveStudentInfoServlet")
public class RetrieveStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveStudentInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		
		StudentInfoManager db = new StudentInfoManager();

		ArrayList<StudentInfoDetails> student = db.retrieveStudentInfo(assessmentId);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("student", student);
		response.sendRedirect("display.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
