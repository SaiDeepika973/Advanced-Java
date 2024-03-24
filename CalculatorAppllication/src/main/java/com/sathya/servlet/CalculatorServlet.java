package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalculatorServlet() {
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step-1: Read the data
		int num1=Integer.parseInt(request.getParameter("first"));
		int num2=Integer.parseInt(request.getParameter("second"));
		String operation=request.getParameter("operation");
		
		//Step-2: Process the data
		int result=0;
		switch(operation)
		{
		case "+":result=num1+num2;
				break;
		case "-":result=num1-num2;
				break;
		case "*":result=num1*num2;
				break;
		case "/":result=num1/num2;
				break;
		case "%":result=num1%num2;
		}
		
		//Step-3: Render the response the client
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("Your operation:"+operation+"<br>");
		writer.println("Your result:"+result+"<br>");
		writer.println("</body>");
		writer.println("</html>");
	}
}