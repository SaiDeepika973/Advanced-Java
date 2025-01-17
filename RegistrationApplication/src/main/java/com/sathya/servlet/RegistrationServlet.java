package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegistrationServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step-1:Read the data
		String name=request.getParameter("username");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		String email=request.getParameter("mail");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		String[] qualification=request.getParameterValues("qualification");
		String country=request.getParameter("country");
		String[] languages=request.getParameterValues("languages");
		String comments=request.getParameter("comments");
		
		//Step-2:Process the data
		String q=String.join(",",qualification);
		String l=String.join(",", languages);
		
		//Step-3:Render the result to client
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("Your Username:"+name+"<br>");
		writer.println("Your Mobile Number:"+mobile+"<br>");
		writer.println("Your Email:"+email+"<br>");
		writer.println("Your Gender:"+gender+"<br>");
		writer.println("Your Date of Birth:"+dob+"<br>");
		writer.println("Your Qualification(s):"+q+"<br>");
		writer.println("Your Country:"+country+"<br>");
		writer.println("Your Languages known:"+l+"<br>");
		writer.println("Your Comments about Ratan Sir:"+comments+"<br>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
