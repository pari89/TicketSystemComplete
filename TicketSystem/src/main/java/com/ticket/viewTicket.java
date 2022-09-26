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
 * Servlet implementation class viewTicket
 */
@WebServlet("/viewTicket")
public class viewTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();
		String uname = s.getAttribute("username").toString();
		String utype = s.getAttribute("usertype").toString();
		if(utype.equalsIgnoreCase("enduser"))
		{
			EndUser A = new EndUser();
			try {
				ResultSet rs = A.viewTickets(uname);
				List<List<String>> lists = new ArrayList<>();
				while(rs.next())
				{
					List<String> ticket = new ArrayList<>();
					ticket.add(rs.getString(1));
					ticket.add(rs.getString(2));
					String se = rs.getString(4);
					if(se==null)
					{
						ticket.add("not assigned");
					}
					else
					{
						ticket.add(se);
					}
					ticket.add(rs.getString(5));
					ticket.add(rs.getString(6));
					lists.add(ticket);
				}
				request.setAttribute("Ticket", lists);
				RequestDispatcher rd = request.getRequestDispatcher("viewticketEU.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(utype.equalsIgnoreCase("serviceengineer"))
		{
			ServiceEngineer A = new ServiceEngineer();
			try {
				ResultSet rs = A.viewTickets(uname);
				List<List<String>> lists = new ArrayList<>();
				while(rs.next())
				{
					List<String> ticket = new ArrayList<>();
					ticket.add(rs.getString(1));
					ticket.add(rs.getString(2));
					ticket.add(rs.getString(3));
					ticket.add(rs.getString(5));
					ticket.add(rs.getString(6));
					lists.add(ticket);
				}
				request.setAttribute("Ticket", lists);
				RequestDispatcher rd = request.getRequestDispatcher("viewticketSE.jsp");
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
