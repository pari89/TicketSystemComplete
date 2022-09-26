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
 * Servlet implementation class addUser
 */
@WebServlet("/addUser")
public class addUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usertp = request.getParameter("usertype");
		String usern = request.getParameter("username");
		String pass = request.getParameter("password");
		Admin A = new Admin();
		try
		{
			if(usertp.equalsIgnoreCase("admin"))
			{
				boolean reg = A.addAdmin(usern, pass);
				if(reg)
				{
					HttpSession session = request.getSession();
					session.setAttribute("usertype",usertp);
					response.sendRedirect("sreg.jsp");
				}
				else
				{
					HttpSession session = request.getSession();
					session.setAttribute("usertype",usertp);
					response.sendRedirect("freg.jsp");
				}
			}
			else if(usertp.equalsIgnoreCase("enduser"))
			{
				boolean reg = A.addEndUser(usern, pass);
				if(reg)
				{
					HttpSession session = request.getSession();
					session.setAttribute("usertype",usertp);
					response.sendRedirect("sreg.jsp");
				}
				else
				{
					HttpSession session = request.getSession();
					session.setAttribute("usertype",usertp);
					response.sendRedirect("freg.jsp");
				}
			}
			else if(usertp.equalsIgnoreCase("serviceengineer"))
			{
				String setype= request.getParameter("setype");
				boolean reg = A.addServiceEngineer(usern, pass,setype);
				if(reg)
				{
					HttpSession session = request.getSession();
					session.setAttribute("usertype",usertp);
					response.sendRedirect("sreg.jsp");
				}
				else
				{
					HttpSession session = request.getSession();
					session.setAttribute("usertype",usertp);
					response.sendRedirect("freg.jsp");
				}
			}
		}
		catch(Exception e)
		{
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
