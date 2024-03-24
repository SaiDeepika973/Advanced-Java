package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

		public int save(Employee emp)
		{
		//declare the resources
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		int count=0;
		try
		{
			//Get the connection
			connection=DbConnection.createConnection();
			preparedStatement=connection.prepareStatement("insert into emp values(?,?,?)");
			
			//read the data from emp object and set to parameters
			preparedStatement.setInt(1, emp.getEmpId());
			preparedStatement.setString(2, emp.getEmpName());
			preparedStatement.setDouble(3, emp.getEmpSalary());
			count=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			//check whether the resources are opened before closing them
			if(connection!=null)
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(preparedStatement!=null)
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return count;
		}
		
		public Employee findById(int empId)
		{
			Employee employee=null;
			
			try(Connection connection=DbConnection.createConnection();
					PreparedStatement preparedStatement=connection.prepareStatement("select * from emp where empId=?"))
			{
				preparedStatement.setInt(1, empId);
				ResultSet resultSet=preparedStatement.executeQuery();
				if(resultSet.next())
				{
					employee=new Employee();
					employee.setEmpId(resultSet.getInt(1));
					employee.setEmpName(resultSet.getString(2));
					employee.setEmpSalary(resultSet.getDouble(3));
					
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return employee;
			}
			
		public int deleteById(int empId)
		{
			int count=0;
			try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where empId=?"))
			{
				preparedStatement.setInt(1,empId);
				count=preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
		}
		
		public int deleteBySalary(double empSalary)
		{
			int count=0;
			try(Connection connection=DbConnection.createConnection();
				PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where empsalary>?"))
			{
				preparedStatement.setDouble(1,empSalary);
				count=preparedStatement.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return count;
		}
		
		public List<Employee> findAll()
		{
			List<Employee> emps=new ArrayList<Employee>();
			try(Connection connection=DbConnection.createConnection();
					Statement statement=connection.createStatement())
			{
				ResultSet resultSet=statement.executeQuery("select * from emp");
				Employee employee=new Employee();
				while(resultSet.next())
				{
					employee.setEmpId(resultSet.getInt(1));
					employee.setEmpName(resultSet.getString(1));
					employee.setEmpSalary(resultSet.getDouble(1));
					emps.add(employee);
				}
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return emps;
		}

}
