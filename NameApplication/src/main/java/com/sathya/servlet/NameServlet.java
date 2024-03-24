package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NameServlet")
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public NameServlet() {
    	
    }
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step-1:Read the request data
		String fname=request.getParameter("firstname");
		String mname=request.getParameter("middlename");
		String lname=request.getParameter("lastname");
		
		//Step-2:Process the data
		String result=fname+" "+mname+" "+lname;
		
		//Step-3:Render the response data
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<p>Your First Name:"+fname+"</p>");
		writer.println("<p>Your Middle Name:"+mname+"</p>");
		writer.println("<p>Your Last Name:"+lname+"</p>");
		writer.println("<p>Your Full Name:"+result+"</p>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
