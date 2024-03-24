package com.sathya.jdbc;

import java.io.*;
public class Jdbcex1
{
	public static void main(String args[])
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver loaded successfully....");
	}
}