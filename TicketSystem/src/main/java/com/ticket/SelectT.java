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
 * Servlet implementation class SelectT
 */
@WebServlet("/SelectT")
public class SelectT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String sen = session.getAttribute("username").toString();
		ServiceEngineer se = new ServiceEngineer();
		try {
			ResultSet rs = se.viewTickets(sen);
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
			request.setAttribute("sub", "To change Status");
			RequestDispatcher rd = request.getRequestDispatcher("SelectT.jsp");
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
