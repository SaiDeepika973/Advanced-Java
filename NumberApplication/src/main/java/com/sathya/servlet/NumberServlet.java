package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NumberServlet")
public class NumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public NumberServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Step-1:Read the requested data
		
		int start=Integer.parseInt(request.getParameter("StartNumber"));
		int end=Integer.parseInt(request.getParameter("EndNumber"));
		String operation=request.getParameter("operation");
		
		//Step-2:Process the data
		ArrayList<Integer> result=new ArrayList<Integer>();
		switch(operation)
		{
		case "Even":for(int i=start;i<=end;i++)
					{
						if(i%2==0)
							result.add(i);
							
					}
					break;
					
		case "Odd":for(int i=start;i<=end;i++)
					{
						if(i%2!=0)
							result.add(i);
					}
					break;
					
		case "Prime":boolean flag=false;
					for(int i=start;i<=end;i++)
					{
						flag=false;
						if(!(i>1))
							flag=true;
						else
						{
							for(int j=2;j<=i/2;j++)
							{
								if(i%j==0)
								{
									flag=true;
									break;
								}
							}
							if(!flag)
								result.add(i);
						}
					}
					break;
					
		case "Perfect":for(int i=start;i<=end;i++)
						{
							int sum=0;
							for(int j=1;j<=i/2;j++)
							{
								if(i%j==0)
									sum=sum+j;
							}
							if(sum==i)
								result.add(i);
						}	
						break;
		case "Strong":for(int i=start;i<=end;i++)
						{
							int temp=i,sum=0;
							while(temp>0)
							{
								int fact=1;
								int rem=temp%10;
								for(int j=rem;j>=1;j--)
									fact=fact*j;
								sum=sum+fact;
								temp=temp/10;
							}
							if(sum==i)
								result.add(i);
							
						}

		}
		
		//Step-3:Render the response
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");
		writer.println("<body bgcolor='pink'>");
		writer.println("<h1>Result:</h1>");
		writer.println("<p>Your Start Number:"+start+"</p>");
		writer.println("<p>Your End Number:"+end+"</p>");
		writer.println("<p> Your result:"+result+"</p>");
		writer.println("</body>");
		writer.println("</html>");
}
}
