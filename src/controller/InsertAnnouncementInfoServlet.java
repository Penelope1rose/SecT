package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AnnouncementInfoManager;

/**
 * Servlet implementation class InsertAnnouncementInfoServlet
 */
@WebServlet("/InsertAnnouncementInfoServlet")
public class InsertAnnouncementInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAnnouncementInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String modCode = request.getParameter("modCode");
		String staffID = request.getParameter("staffID");
		String staffName = request.getParameter("staffName");
		String announcement = request.getParameter("announcement");
		
		AnnouncementInfoManager db = new AnnouncementInfoManager();

		db.insertAnnouncementInfo(modCode, staffID, staffName, announcement);

		response.sendRedirect("RetrieveAllAnnouncementInfoServlet?staffID="+staffID);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
