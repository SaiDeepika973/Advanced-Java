package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public ProductServlet() {
    }       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//step-1: Read the requested data
		int proId=Integer.parseInt(request.getParameter("proId"));
		String proName=request.getParameter("proName");
		Double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		int proQuantity=Integer.parseInt(request.getParameter("proQuantity"));
		Double totalBill=Double.parseDouble(request.getParameter("proPrice"))*Double.parseDouble(request.getParameter("proQuantity"));
		Double discount=0.0;
		Double netPrice=0.0;
		
		//step-2: Process the data
		if(totalBill<1000)
		{
			discount=0.0;
		}
		else if(totalBill>1000 && totalBill<5000)
		{
			discount=0.01*totalBill;
		}
		else if(totalBill>10000)
		{
			discount=(15*totalBill)/100;
		}
		netPrice=totalBill-discount;
		
		//step-3: Render the response
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor=pink");
		writer.println("<h1><b>product Bill Invoice:</b></h1>");
		writer.println("<p><i>productId:</i>"+proId);
		writer.println("<p><i>productName:</i>"+proName);
		writer.println("<p><i>productPrice:</i>"+proPrice);
		writer.println("<p><i>ProductQuantity:</i>"+proQuantity);
		writer.println("<p><i>TotalBill:</i>"+totalBill);
		writer.println("<p><i>NetPrice:</i>"+netPrice);
		writer.println("</body>");
		writer.println("</html>");
	}
  }