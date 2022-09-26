package com.ticket;
import Back.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Raise
 */
@WebServlet("/Raise")
public class Raise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Raise() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();
		String usern = s.getAttribute("username").toString();
		String tickn = request.getParameter("ticketName");
		String tickt= request.getParameter("ticketType");
		String tickD = request.getParameter("ticketDes");
		String usertp = s.getAttribute("usertype").toString();
		EndUser E = new EndUser();
		try {
			int i= E.raiseTicket(usern, tickn, tickt,tickD);
			if(i==1)
			{
				HttpSession session = request.getSession();
				session.setAttribute("usertype",usertp);
				response.sendRedirect("tickRS.jsp");
			}
			else if(i==2)
			{
				HttpSession session = request.getSession();
				session.setAttribute("usertype",usertp);
				response.sendRedirect("tickRNS.jsp");
			}
			else if(i==3)
			{
				HttpSession session = request.getSession();
				session.setAttribute("usertype",usertp);
				response.sendRedirect("tickE.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
