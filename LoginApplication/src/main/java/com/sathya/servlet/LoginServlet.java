package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step-1:Read the data
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		
		//Step-2:process the data
		String result;
		if(username.equals("Deepika") && password.equals("Dpka"))
			result="Login Successful";
		else
			result="Invalid credentials! Please try again";
		
		//Step-3:Render the response to client
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<p>"+result+"</p>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
