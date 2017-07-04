package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ModuleInfoDetails;
import model.ModuleInfoManager;

/**
 * Servlet implementation class RetrieveModuleInfoServlet
 */
@WebServlet("/RetrieveModuleInfoServlet")
public class RetrieveModuleInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveModuleInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String staffID = request.getParameter("staffID");

		ModuleInfoManager db = new ModuleInfoManager();

		ArrayList<ModuleInfoDetails> module = db.retrieveModuleInfo(staffID);

		HttpSession session = request.getSession();
		session.setAttribute("module", module);
			
		response.sendRedirect("home.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
