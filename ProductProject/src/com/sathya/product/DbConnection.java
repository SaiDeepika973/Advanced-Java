package com.sathya.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection createConnection(){
		Connection connection=null;
		try
		{
			//loading the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//creating the connection
		connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","saidpka","deepika");
		}
		catch(ClassNotFoundException |SQLException e)
		{
			e.printStackTrace();
		}
		//return the connection
		return connection;
		
	}

}
