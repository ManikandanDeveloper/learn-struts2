package com.manikandan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUDPreparedStatement {

	private static final String url = "jdbc:postgresql://localhost:5432/sample";
	private static final String username = "postgres";
	private static final String password = "root";
	
	public static void main(String[] args) {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement statement = connection.prepareStatement("INSERT INTO employee VALUES (?, ?, ?)");
			
			statement.setInt(1, 102);
			statement.setString(2, "Dastan");
			statement.setInt(3, 20000);
			
			int rowsAffected = statement.executeUpdate();
			
			System.out.println(rowsAffected + " rows affected.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				System.out.println("Connection is successfully closed.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
