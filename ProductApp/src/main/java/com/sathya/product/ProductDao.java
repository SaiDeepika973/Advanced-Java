package com.sathya.product;

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
			preparedStatement=connection.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1,product.getProId());
			preparedStatement.setString(2, product.getProName());
			preparedStatement.setDouble(3, product.getProPrice());
			preparedStatement.setString(4, product.getProBrand());
			preparedStatement.setString(5, product.getProMadeIn());
			preparedStatement.setDate(6,product.getProManufactured());
			preparedStatement.setDate(7, product.getProExpiry());
			preparedStatement.setBytes(8, product.getProImage());
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
			ResultSet resultSet=statement.executeQuery("select * from product_data");
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
				products.add(product);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return products;
	}

}
