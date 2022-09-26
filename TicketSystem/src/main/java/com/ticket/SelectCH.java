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

import Back.ServiceEngineer;

/**
 * Servlet implementation class SelectCH
 */
@WebServlet("/SelectCH")
public class SelectCH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCH() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tN = request.getParameter("ticketName");
		ServiceEngineer se = new ServiceEngineer();
		HttpSession s = request.getSession();
		String sen = s.getAttribute("username").toString();
		try {
			se.pickTicket(sen, tN);
			ResultSet rs = se.getType(tN);
			rs.next();
			List<String> Ticket = new ArrayList<>();
			Ticket.add(rs.getString(1));
			Ticket.add(rs.getString(2));
			Ticket.add(rs.getString(3));
			Ticket.add(rs.getString(5));
			Ticket.add(rs.getString(6));			
			request.setAttribute("Ticket", Ticket);
			RequestDispatcher rd = request.getRequestDispatcher("SelectS.jsp");
			rd.forward(request, response);
		}
		catch (Exception e) {
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
