package com.sathya.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThirdServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<pre color:'green'>");
		writer.println("User Name:"+cookies[0]);
		writer.println("Age:"+cookies[1]);
		writer.println("Qualification:"+cookies[2]);
		writer.println("Designation:"+cookies[3]);
		writer.println("Email ID:"+request.getParameter("email"));
		writer.println("Mobile Number:"+request.getParameter("mobile"));
		writer.println("</pre>");
		writer.println("</body>");
		writer.println("</html>");
		
	}

}
