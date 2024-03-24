package com.sathya.jdbc;

import java.sql.SQLException;
import java.util.List;

public class DataBaseClient {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeDao employeeDao=new EmployeeDao();
		
		//insert records using save method
		int res1=employeeDao.save(new Employee(101,"Anna",45000));
		System.out.println("Data Inserted Successfully..."+res1);
		int res2=employeeDao.save(new Employee(102,"Ayesha",52100));
		System.out.println("Data Inserted Successfully...."+res2);
		int res3=employeeDao.save(new Employee(103,"Rachel",29000));
		System.out.println("Data Inserted Successfully...."+res3);
		int res4=employeeDao.save(new Employee(104,"Dannie",48000));
		System.out.println("Data Inserted Successfully...."+res4);
		int res5=employeeDao.save(new Employee(105,"Jezelle",65000));
		System.out.println("Data Inserted Successfully...."+res5);
		
				//select data using Id
				Employee emp=employeeDao.findById(101);
				System.out.println(emp);
				
				Employee emp2=employeeDao.findById(102);
				System.out.println(emp2);
				
				Employee emp3=employeeDao.findById(103);
				System.out.println(emp3);
				
				Employee emp4=employeeDao.findById(140);
				System.out.println(emp4);
				
				//delete data using Id
				int deletecount=employeeDao.deleteById(101);
				if(deletecount!=0)
					System.out.println("Record deleted successfully");
				else
					System.out.println("Deletion failed...");
				
				//delete data using Salary
				int dcount=employeeDao.deleteBySalary(50000);
				if(dcount==0)
					System.out.println("Deletion failed...");
				else
					System.out.println(dcount+" records deleted");
				
				//display all records
				List<Employee> l=employeeDao.findAll();
				l.forEach(e->System.out.println(e));
	}
		
}
