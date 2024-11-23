package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnector {
	public static String getParticularData() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/employees";
		String username = "root";
		String password = "Mythilan@942";
		String query = "select * from employees";

		// connection estabilize
		Connection connection = DriverManager.getConnection(url, username, password);
		// Create a statement
		Statement statement = connection.createStatement();
		// Execute Query
		ResultSet result = statement.executeQuery(query);

		result.next();

		String firstname = result.getString(3);
		return firstname;

	}
	public static void getalldata() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/employees";
		String username = "root";
		String password = "Mythilan@942";
		String query = "select * from employees limit 5";
		
		// connection estabilize
		Connection connection = DriverManager.getConnection(url, username, password);
		// Create a statement
		Statement statement = connection.createStatement();
		// Execute Query
		ResultSet result = statement.executeQuery(query);


		
	}
	

}
