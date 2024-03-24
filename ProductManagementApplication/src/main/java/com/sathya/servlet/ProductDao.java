package com.sathya.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductDao {
	
	public int saveProduct(Product product)
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int count=0;
		try
		{
			connection=DataBaseUtils.createConnection();
			preparedStatement=connection.prepareStatement("insert into product_details values(?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1,product.getProId());
			preparedStatement.setString(2, product.getProName());
			preparedStatement.setDouble(3, product.getProPrice());
			preparedStatement.setString(4, product.getProBrand());
			preparedStatement.setString(5, product.getProMadeIn());
			preparedStatement.setDate(6,product.getProManufactured());
			preparedStatement.setDate(7, product.getProExpiry());
			preparedStatement.setBytes(8, product.getProImage());
			preparedStatement.setBytes(9, product.getProAudio());
			preparedStatement.setBytes(10, product.getProVideo());
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(preparedStatement!=null)
				try {
					preparedStatement.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
		}	
			if(connection!=null)
				try {
					connection.close();
					} 
				catch (SQLException e) {
					e.printStackTrace();
										}
			}
		
	
		return count;
	}
	
	public List<Product> findAll()
	{
		List<Product> products=new ArrayList<Product>();
		Product product=null;
		
		try(Connection connection=DataBaseUtils.createConnection();
				Statement statement=connection.createStatement())
		{
			ResultSet resultSet=statement.executeQuery("select * from product_details");
			while(resultSet.next())
			{
				product=new Product();
				product.setProId(resultSet.getInt("proId"));
				product.setProName(resultSet.getString("proName"));
				product.setProPrice(resultSet.getDouble("proPrice"));
				product.setProBrand(resultSet.getString("proBrand"));
				product.setProMadeIn(resultSet.getString("proMadeIn"));
				product.setProManufactured(resultSet.getDate("proManufactured"));
				product.setProExpiry(resultSet.getDate("proExpiry"));
				product.setProImage(resultSet.getBytes("proImage"));
				product.setProAudio(resultSet.getBytes("proAudio"));
				product.setProVideo(resultSet.getBytes("proVideo"));
				products.add(product);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return products;
	}
	
	public int deleteById(String id)
	{
		int count=0;
		try(Connection connection=DataBaseUtils.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("delete from product_details where proid=?"))
		{
				preparedStatement.setString(1, id);
				count=preparedStatement.executeUpdate();	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return count;
	}
	public Product findById(String id)
	{
		Product product=null;
		try(Connection connection=DataBaseUtils.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("select * from product_details where proid=?"))
		{
			preparedStatement.setString(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
			product=new Product();
			product.setProId(resultSet.getInt("proId"));
			product.setProName(resultSet.getString("proName"));
			product.setProPrice(resultSet.getDouble("proPrice"));
			product.setProBrand(resultSet.getString("proBrand"));
			product.setProMadeIn(resultSet.getString("proMadeIn"));
			product.setProManufactured(resultSet.getDate("proManufactured"));
			product.setProExpiry(resultSet.getDate("proExpiry"));
			product.setProImage(resultSet.getBytes("proImage"));
			product.setProAudio(resultSet.getBytes("proAudio"));
			product.setProVideo(resultSet.getBytes("proVideo"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return product;
	}
	
	public int updateById(Product product)
	{
		String sql="UPDATE product_details SET proName=?, proPrice=?, proBrand=?,proMadeIn=?, proManufactured=?, proExpiry=?, proImage=?, proAudio=?, proVideo=? where proId=?";
		int updateResult=0;
		try(Connection connection=DataBaseUtils.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(sql))
		{
			preparedStatement.setString(1, product.getProName());
			preparedStatement.setDouble(2, product.getProPrice());
			preparedStatement.setString(3, product.getProBrand());
			preparedStatement.setString(4, product.getProMadeIn());
			preparedStatement.setDate(5, product.getProManufactured());
			preparedStatement.setDate(6, product.getProExpiry());
			preparedStatement.setBytes(7,product.getProImage());
			preparedStatement.setBytes(8, product.getProAudio());
			preparedStatement.setBytes(9,product.getProVideo());
			preparedStatement.setInt(10, product.getProId());
			
			updateResult=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return updateResult;
	}
	
	
	
	
}