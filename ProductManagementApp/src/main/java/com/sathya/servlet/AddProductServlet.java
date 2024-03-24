package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddProductServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read the data from html page
		int id=Integer.parseInt(request.getParameter("proId"));
		String name=request.getParameter("proName");
		double price=Double.parseDouble(request.getParameter("proPrice"));
		String brand=request.getParameter("proBrand");
		String madein=request.getParameter("proMadeIn");
		Date manufactured=Date.valueOf(request.getParameter("proManufactured"));
		Date expiry=Date.valueOf(request.getParameter("proExpiry"));
		Part part=request.getPart("proImage");
		InputStream image=part.getInputStream();
		
		//conversion of InputStream into byte[]
		byte[] proImage = IOUtils.toByteArray(image);
		
		Part part1=request.getPart("proAudio");
		InputStream inputStream1=part1.getInputStream();
		byte[] proAudio=IOUtils.toByteArray(inputStream1);
		
		Part part2=request.getPart("proVideo");
		InputStream inputStream2=part2.getInputStream();
		byte[] proVideo=IOUtils.toByteArray(inputStream2);
		
		Product product=new Product();
		product.setProId(id);
		product.setProName(name);
		product.setProPrice(price);
		product.setProBrand(brand);
		product.setProMadeIn(madein);
		product.setProManufactured(manufactured);
		product.setProExpiry(expiry);
		product.setProImage(proImage);
		product.setProAudio(proAudio);
		product.setProVideo(proVideo);
		
		//send the data to employee dao
		ProductDao dao=new ProductDao();
		int result=dao.saveProduct(product);
		
		if(result==1)
		{
			//To send the data to JSP file add the data to request object
			request.setAttribute("saveResult",result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("productlist.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("Data insertion failed check once....."+result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("product-add.html");
			dispatcher.include(request, response);
		}
	}

}
