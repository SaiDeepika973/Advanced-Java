package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {
	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","saidpka","deepika");
			statement=connection.createStatement();
			connection.setAutoCommit(false);
			statement.executeUpdate("insert into emp values(1001,'Sai',30000000)");
			statement.executeUpdate("insert into emp values(1005,'Syed',300000)");
			statement.executeUpdate("insert into emp values(1006,'Rafi',98000)");
			statement.executeUpdate("insert into emp values(1007,'Ganesh',50000)");
			statement.executeUpdate("insert into emp values(1008,'Geetha',74500)");
			statement.executeUpdate("insert into emp values(1009,'Dileep',40000)");
			statement.executeUpdate("insert into emp values(1010,'Dinesh',800000)");
			connection.commit();
		}
		catch(ClassNotFoundException | SQLException e)
		{
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(statement!=null)
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

}
