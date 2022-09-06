package org.fos.javaproject;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SimpleServlet
 */
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();
		
		if(request.getParameterMap().containsKey("UserName") && request.getParameter("UserName") != "") {
			String userName = request.getParameter("UserName");
			writer.println("<h3>Hello " + userName + "</h3>");
			session.setAttribute("savedNameAttribute", userName);
			
			writer.println("Request parameter equals- " + userName + "<br>");
		}
		// Actually works fine without casting, but to be sure ill do it.
		writer.println("We saved your name into session parameters and it equals- " + (String) session.getAttribute("savedNameAttribute") + "<br>");

		
		writer.println("This is GET method");
	}
	


}
