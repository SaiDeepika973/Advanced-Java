package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbcex1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Step-1:Load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded successfully....");

		//Step-2:Create the connection
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","saidpka","deepika");
		System.out.println("Connection created successfully...");
		
		//Step-4:Release the connection
		connection.close();
		System.out.println("Connection released successfully....");
	}

}
