package com.sathya.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DirectExample")
public class DirectExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DirectExample() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals("Deepika") && password.equals("saidpka"))
			response.sendRedirect("http://www.tcs.com");
		else
			response.sendError(808,"Login Fail check the details once");
	}

}
