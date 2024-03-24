package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step-1: Read the requested data
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		double bsalary=Double.parseDouble(request.getParameter("salary"));
		
		//Step-2: Process the data
		double hra,da,pf;
		if(bsalary>50000)
		{
			hra=bsalary*0.3;
			da=bsalary*0.1;
			pf=bsalary*0.06;
		}
		else if(bsalary<50000 && bsalary>25000)
		{
			hra=bsalary*0.2;
			da=bsalary*0.05;
			pf=bsalary*0.03;
		}
		else
		{
			hra=bsalary*0.1;
			da=bsalary*0.03;
			pf=bsalary*0.02;
		}
		double gsalary=bsalary+da+hra-pf;
		
		//Step-3: Render response to the client
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("Employee Id:"+id+"<br>");
		writer.println("Employee Name:"+name+"<br>");
		writer.println("Employee Basic Salary:"+bsalary+"<br>");
		writer.println("Employee HRA:"+hra+"<br>");
		writer.println("Employee DA:"+da+"<br>");
		writer.println("Employee PF:"+pf+"<br>");
		writer.println("Employee Gross Salary:"+gsalary+"<br>");
		writer.println("</body>");
		writer.println("</html>");
		
	}

}
