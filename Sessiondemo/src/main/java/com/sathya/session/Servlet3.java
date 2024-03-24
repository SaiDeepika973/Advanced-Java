package com.sathya.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Servlet3() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession(false);
			//render the response to client
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("<html>");
			writer.println("<body style>");
			writer.println("<pre style=color:blue>");
			writer.println("Username:"+session.getAttribute("username"));
			writer.println("Age:"+session.getAttribute("age"));
			writer.println("Qualification:"+session.getAttribute("qualification"));
			writer.println("Designation:"+session.getAttribute("designation"));
			writer.println("Email:"+request.getParameter("email"));
			writer.println("Mobile Number:"+request.getParameter("mobile"));
			writer.println("</pre>");
			writer.println("<body>");
			writer.println("<html>");
	}

}
