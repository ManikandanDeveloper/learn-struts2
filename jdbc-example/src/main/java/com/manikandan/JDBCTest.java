package com.manikandan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	
	private static final String url = "jdbc:postgresql://localhost:5432/sample";
	private static final String username = "postgres";
	private static final String password = "root";

	public static void main(String[] args) {
		Connection connection = null;

		try {
			System.out.println("Initiating DB connection...");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection is obtained");
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				
				System.out.printf("id=%d, name=%s\n", id, name);
			}
		} catch (SQLException e) {
			System.out.println("Connection attempt failed.");
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					System.out.println("Closing the connection...");
					connection.close();
					System.out.println("Connection has been closed.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
