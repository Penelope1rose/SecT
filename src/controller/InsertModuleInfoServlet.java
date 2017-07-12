package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModuleInfoManager;

/**
 * Servlet implementation class InsertModuleInfoServlet
 */
@WebServlet("/InsertModuleInfoServlet")
public class InsertModuleInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertModuleInfoServlet() {
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
		
		ModuleInfoManager db = new ModuleInfoManager();

		db.insertModuleInfo(modCode, modName, staffID);

		response.sendRedirect("RetrieveModuleInfoServlet?staffID="+staffID);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
