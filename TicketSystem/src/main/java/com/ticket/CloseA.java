package com.ticket;

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

import Back.EndUser;
import Back.ServiceEngineer;

/**
 * Servlet implementation class CloseA
 */
@WebServlet("/CloseA")
public class CloseA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tN = request.getParameter("ticketName");
		HttpSession s = request.getSession();
		String ut = s.getAttribute("usertype").toString();
		if(ut.equalsIgnoreCase("enduser"))
		{
			EndUser E = new EndUser();
			try {
				E.closeTicket(tN);
				response.sendRedirect("closeS.jsp");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ut.equalsIgnoreCase("serviceengineer"))
		{
			ServiceEngineer se = new ServiceEngineer();
			String cS="close";
			try {
				boolean f = se.changeStatus(tN, cS);
				if(f)
				{
					ResultSet rs1 = se.getType(tN);
					rs1.next();
					ResultSet rs = se.viewTicketsL(rs1.getString(2));
					List<List<String>> Ticket = new ArrayList<>();
					while(rs.next())
					{
						List<String> l = new ArrayList<>();
						l.add(rs.getString(1));
						l.add(rs.getString(2));
						l.add(rs.getString(3));
						l.add(rs.getString(5));
						l.add(rs.getString(6));
						Ticket.add(l);
					}
					request.setAttribute("Ticket", Ticket);
					request.setAttribute("sub","Status Change successful! As you have relieved the ticket please select the next ticket you want to resolve.");
					RequestDispatcher rd = request.getRequestDispatcher("SelectCH.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("Message", "Ticket status could not be changed");
					RequestDispatcher rd = request.getRequestDispatcher("changeUs.jsp");
					rd.forward(request, response);
				}
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
