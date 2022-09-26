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

import Back.Admin;

/**
 * Servlet implementation class viewUser
 */
@WebServlet("/viewUser")
public class viewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin A = new Admin();
		try {
			ResultSet rs = A.viewUsers();
			List<List<String>> lists = new ArrayList<>();
			while(rs.next())
			{
				List<String> user = new ArrayList<>();
				user.add(rs.getString(1));
				user.add(rs.getString(2));
				user.add(rs.getString(4));
				user.add(rs.getString(7));
				lists.add(user);
				
			}
			request.setAttribute("users", lists);
			HttpSession session = request.getSession();
			session.setAttribute("usertype","Admin");
			RequestDispatcher rd = request.getRequestDispatcher("viewUser.jsp");
			rd.forward(request, response);
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
