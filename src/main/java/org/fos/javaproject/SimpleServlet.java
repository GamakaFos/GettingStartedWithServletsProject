package org.fos.javaproject;

import jakarta.servlet.ServletContext;
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
		ServletContext context = request.getServletContext();
		
		if(request.getParameterMap().containsKey("UserName") && request.getParameter("UserName") != "") {
			String userName = request.getParameter("UserName");
			writer.println("<h3>Hello " + userName + "</h3>");
			session.setAttribute("savedNameAttribute", userName);
			context.setAttribute("savedNameAttribure", userName);
			
			writer.println("Request parameter equals- " + userName + "<br>");
		}
		
		

		
		//if(session.)
		// Actually works fine without casting, but to be sure ill do it.
		writer.println("We saved your name into SESSION parameters and it equals- " + (String) session.getAttribute("savedNameAttribute") + "<br>");
		// Adding values to the context is similar to adding values to the session.
		writer.println("We saved your name into CONTEXT parameters and it equals- " + (String) context.getAttribute("savedNameAttribure") + "<br>");
		
		writer.println("This is GET method");
	}
	


}
