package com.sathya.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Servlet1() {
        super();

    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get the data from client
		String name=request.getParameter("username");
		int age=Integer.parseInt(request.getParameter("age"));
		
		//create session object
		HttpSession session=request.getSession();
		
		//place the data into session object
		session.setAttribute("username", name);
		session.setAttribute("age", age);
		
		//give the next form to the client
		RequestDispatcher dispatcher=request.getRequestDispatcher("form2.html");
		dispatcher.forward(request, response);
	}

}
