package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingDemo {
	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","saidpka","deepika");
		Statement statement=connection.createStatement();
			statement.addBatch("insert into emp values(1004,'Sai',500000)");
			statement.addBatch("delete from emp where empid=1001");
			int[] a=statement.executeBatch();
			for(int o:a)
				System.out.println(o);
			connection.close();
		
	}

}
