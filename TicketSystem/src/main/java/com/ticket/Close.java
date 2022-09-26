package com.ticket;
import Back.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Close
 */
@WebServlet("/Close")
public class Close extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Close() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String tn = request.getParameter("ticketName");
		HttpSession s = request.getSession();
		String ut = s.getAttribute("usertype").toString();
		String un = s.getAttribute("username").toString();
		if(ut.equalsIgnoreCase("enduser"))
		{
			EndUser E = new EndUser();
			try {
				ResultSet rs = E.viewTicketsC(un);
				List<String> ticket = new ArrayList<>();
				while(rs.next())
				{
					String tn1 = rs.getString(1);
					ticket.add(tn1);
				}
				request.setAttribute("Ticket", ticket);
				RequestDispatcher rd = request.getRequestDispatcher("close.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ut.equalsIgnoreCase("serviceengineer"))
		{
			ServiceEngineer E = new ServiceEngineer();
			try {
				ResultSet rs = E.viewTicketsC(un);
				List<String> ticket = new ArrayList<>();
				while(rs.next())
				{
					String tn1 = rs.getString(1);
					ticket.add(tn1);
				}
				request.setAttribute("Ticket", ticket);
				RequestDispatcher rd = request.getRequestDispatcher("close.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
