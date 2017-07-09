package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AnnouncementInfoDetails;
import model.AnnouncementInfoManager;

/**
 * Servlet implementation class RetrieveAnnouncementInfoServlet
 */
@WebServlet("/RetrieveAnnouncementInfoServlet")
public class RetrieveAnnouncementInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveAnnouncementInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String staffID = request.getParameter("staffID");
		String modCode = request.getParameter("modCode");
		
		AnnouncementInfoManager db = new AnnouncementInfoManager();

		ArrayList<AnnouncementInfoDetails> announcement = db.retrieveAnnouncement(staffID, modCode);

		HttpSession session = request.getSession();
		
		session.removeAttribute("REFRESH");

		session.setAttribute("announcement", announcement);
		response.sendRedirect("home.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
