package com.sathya.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet2() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get the data from client
				String qualification=request.getParameter("qualification");
				String designation=request.getParameter("designation");
				
				//create session object
				HttpSession session=request.getSession(false);
				
				//place the data into session object
				session.setAttribute("qualification", qualification);
				session.setAttribute("designation", designation);
				
				//give the next form to the client
				RequestDispatcher dispatcher=request.getRequestDispatcher("form3.html");
				dispatcher.forward(request, response);
	}

}
