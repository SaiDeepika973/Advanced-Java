package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ddl {
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		//Load the driver
		Class.forName("oracle.jdbc.OracleDriver");
		
		//create the connection
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","saidpka","deepika");
		
		//static query execution
		Statement statement=connection.createStatement();
		
		String q1="create table emp(empid number(5),empname varchar2(10),empsalary number(10,2))";
		int res1=statement.executeUpdate(q1);
		System.out.println("Table created successfully...."+res1);
		
		String q2="drop table emp";
		int res2=statement.executeUpdate(q2);
		System.out.println("Table dropped successfully...."+res2);
		
		connection.close();
		
	}
	

}
