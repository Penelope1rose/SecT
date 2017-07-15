package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DomainInfoManager;

/**
 * Servlet implementation class DeleteDomainInfoServlet
 */
@WebServlet("/DeleteDomainInfoServlet")
public class DeleteDomainInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDomainInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int hiddenID = Integer.parseInt(request.getParameter("hiddenID"));
		int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		
		DomainInfoManager db = new DomainInfoManager();

		db.deleteDomainInfo(hiddenID);
			
		response.sendRedirect("RetrieveDomainInfoServlet?assessmentId="+assessmentId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
