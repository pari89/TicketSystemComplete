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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("username");
		String pass= request.getParameter("password");
		User u = new User();
		String utype;
		try {
			utype = u.login(uname, pass);
			if(utype==null)
			{
				response.sendRedirect("wrong.jsp");
			}
			else if(utype.equalsIgnoreCase("admin"))
			{
				HttpSession session = request.getSession();
				session.setAttribute("usertype",utype);
				session.setAttribute("username",uname);
				response.sendRedirect("admin.jsp");
			}
			else if(utype.equalsIgnoreCase("enduser"))
			{
				HttpSession session = request.getSession();
				session.setAttribute("usertype",utype);
				session.setAttribute("username",uname);
				response.sendRedirect("enduser.jsp");
			}
			else if(utype.equalsIgnoreCase("serviceengineer"))
			{
				HttpSession session = request.getSession();
				session.setAttribute("usertype",utype);
				session.setAttribute("username",uname);
				response.sendRedirect("service.jsp");
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
