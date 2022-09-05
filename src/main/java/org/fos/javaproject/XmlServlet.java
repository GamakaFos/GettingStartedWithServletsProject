package org.fos.javaproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		out.println("Hello from GET method to " + userName + "!");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Input element simply returns after requesting it by name from form
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		out.println("Hello from POST method to " + firstName + "! We know your full name is- " + firstName + " " + lastName + "!");
		
		// Radio button is as simple as input. just a name
		if(request.getParameterMap().containsKey("prof")) {
			String prof = request.getParameter("prof");
			out.println("You are a " + prof);
	
		}
		
		// Same goes to select element
		String location = request.getParameter("location");
		out.println("You came " + location);
		
		// But for multiple elements we have to recieve an array
		if(request.getParameterMap().containsKey("transport")) {
			ArrayList<String> transportArr = new ArrayList<>(Arrays.asList(request.getParameterValues("transport")));	
			for(String element: transportArr) {
				out.println(" either by " + element);
			}
			out.println(" or by walk");
		}
	}
	
}
