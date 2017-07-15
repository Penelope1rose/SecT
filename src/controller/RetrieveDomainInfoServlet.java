package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DomainInfoDetails;
import model.DomainInfoManager;

/**
 * Servlet implementation class RetrieveDomainInfoServlet
 */
@WebServlet("/RetrieveDomainInfoServlet")
public class RetrieveDomainInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveDomainInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		
		DomainInfoManager db = new DomainInfoManager();

		ArrayList<DomainInfoDetails> Domain = db.retrieveDomainInfo(assessmentId);

		HttpSession session = request.getSession();
			
		session.setAttribute("domain", Domain);
		response.sendRedirect("RetrieveAssessmentDomainInfoServlet?assessmentId="+assessmentId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
