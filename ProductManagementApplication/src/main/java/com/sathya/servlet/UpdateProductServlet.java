package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/UpdateProductServlet")
@MultipartConfig
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public UpdateProductServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int updatedProId=Integer.parseInt(request.getParameter("proId"));
		String updatedproName=request.getParameter("proName");
		double updatedproPrice=Double.parseDouble(request.getParameter("proPrice"));
		String updatedproBrand=request.getParameter("proBrand");
		String updatedproMadeIn=request.getParameter("proMadeIn");
		Date updatedproManufactured=Date.valueOf(request.getParameter("proManufactured"));
		Date updatedproExpiry=Date.valueOf(request.getParameter("proExpiry"));
		
		
		Product product=new Product();
		product.setProId(updatedProId);
		product.setProName(updatedproName);
		product.setProPrice(updatedproPrice);
		product.setProBrand(updatedproBrand);
		product.setProMadeIn(updatedproMadeIn);
		product.setProManufactured(updatedproManufactured);
		product.setProExpiry(updatedproExpiry);
		
		Part filePart=request.getPart("newProImage");
		if(filePart!=null && filePart.getSize()>0)
		{
			InputStream inputStream=filePart.getInputStream();
			byte[] newImageData=IOUtils.toByteArray(inputStream);
			product.setProImage(newImageData);
		}
		else
		{
			String s=request.getParameter("existingImage");
			byte[] existingImage=Base64.getDecoder().decode(s);
			product.setProImage(existingImage);
		}
		
		Part filePart1=request.getPart("newProAudio");
		if(filePart1!=null && filePart1.getSize()>0)
		{
			InputStream inputStream3=filePart1.getInputStream();
			byte[] newAudioData1=IOUtils.toByteArray(inputStream3);
			product.setProAudio(newAudioData1);
		}
		else
		{
			String s=request.getParameter("existingAudio");
			byte[] existingAudio=Base64.getDecoder().decode(s);
			product.setProAudio(existingAudio);
		}
		
		Part filePart2=request.getPart("newProVideo");
		if(filePart2!=null && filePart2.getSize()>0)
		{
			InputStream inputStream4=filePart2.getInputStream();
			byte[] newVideoData=IOUtils.toByteArray(inputStream4);
			product.setProVideo(newVideoData);
		}
		else
		{
			String s=request.getParameter("existingVideo");
			byte[] existingVideo=Base64.getDecoder().decode(s);
			product.setProVideo(existingVideo);
		}
		
		ProductDao dao=new ProductDao();
		int result=dao.updateById(product);
		if(result==1)
		{		
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("productlist.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.setContentType("text/html");
			PrintWriter writer=response.getWriter();
			writer.println("Data updation failed check once...."+result);
			RequestDispatcher dispatcher=request.getRequestDispatcher("editform.jsp");
			dispatcher.include(request, response);
		}
		
		
	}

}
