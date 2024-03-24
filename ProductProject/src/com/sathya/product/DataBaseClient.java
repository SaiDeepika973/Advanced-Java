package com.sathya.product;

import java.util.List;

public class DataBaseClient {

	public static void main(String[] args) {

		ProductDao d=new ProductDao();
		
		//table creation
		
		int count=d.CreateProductTable();
		if(count==0)
			System.out.println("Table created successfully");
		else
			System.out.println("Table creation failed");
		
		//inserting records
		
		int count1=d.saveProduct(new Product(1,"Television",40000));
		if(count1==1)
			System.out.println("Record inserted successfully");
		else
			System.out.println("Insertion failed");
		
		//print the employee details by id
		
		Product product=d.getProductById(1);
		if(product!=null)
			System.out.println(product);
		else
			System.out.println("No such record exists");
		
		//get all products
		
		List<Product> pro=d.getAllProducts();
		if(pro.isEmpty())
			System.out.println("No records exist in the table");
		else
		{
			for(Product p:pro)
			System.out.println(p);
		}
		
		//update by price
		
		int count2=d.updateByPrice(400,50);
		if(count2==0)
			System.out.println("No such record exists");
		else
			System.out.println(count2+" records updated");
		
		//delete by id
		
		int count3=d.deleteById(5);
		if(count3==0)
			System.out.println("No such record exists");
		else
			System.out.println(count3+" records deleted");
		
		//delete by price
		
		int count4=d.deleteByPrice(45000);
		if(count4==0)
			System.out.println("No such record exists");
		else
			System.out.println(count4+" records deleted");
		
		//drop table
		
		int count5=d.dropTable();
		if(count5==0)
			System.out.println("Table dropped successfully");
		else
			System.out.println("No such table exists");
			
		
	}
	

}
