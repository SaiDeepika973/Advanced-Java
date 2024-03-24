
package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestExample")
public class RequestExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RequestExample() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals("Deepika") && password.equals("saidpka")) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("success.html");
		dispatcher.forward(request, response);
		}
		else {
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("Login failed check the credentials once....");
			RequestDispatcher dispatcher=request.getRequestDispatcher("requestform.html");
			dispatcher.include(request, response);
		}
	}

}
