package com.automationpractice.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.automationpractice.utilities.DatabaseUtils;

public class JDBCTester {
	public static void main(String[] args) throws SQLException {
		
		DatabaseUtils db = new DatabaseUtils();
		db.createConnection();
		
		System.out.println("connection succesful!");
		
	 List<Map<String, Object>> quaryResultSet = db.getQueryResultMap("select first_name, last_name from employees limit 10");
		for (Map<String, Object> list : quaryResultSet) {
			System.out.println(list);
		}
		
//		String user = "jamshidr";
//		String password = "Abdurahim2";
//		String url = "jdbc:mysql://drdatabase.cs8jy4rssofa.us-east-2.rds.amazonaws.com/employees";
//		
//		Connection connection = DriverManager.getConnection(url, user, password);
//		
//		System.out.println("Database connection");
//		
//		Statement statement = connection.createStatement();
//		
//		ResultSet rs =  statement.executeQuery("SELECT * FROM employees limit 10");
//		
//		while(rs.next())
//		System.out.println(rs.getObject("first_name")+"\t"+rs.getObject("last_name"));
	}

}
