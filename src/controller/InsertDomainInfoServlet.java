package controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DomainInfoManager;

/**
 * Servlet implementation class InsertDomainInfoServlet
 */
@WebServlet("/InsertDomainInfoServlet")
public class InsertDomainInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDomainInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String staffID = request.getParameter("staffID");
		int assessmentId = Integer.parseInt(request.getParameter("assessmentId"));
		String domains = request.getParameter("domain");
		String whitelistdomain[] = domains.split(",");
		
		DomainInfoManager db = new DomainInfoManager();

		for (int i=0; i<whitelistdomain.length; i++) {
			db.insertDomainInfo(whitelistdomain[i], assessmentId, staffID);
		}

		response.sendRedirect("RetrieveDomainInfoServlet?assessmentId="+assessmentId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
