package com.manikandan;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CRUDCallableStatement {
	
	private static final String url = "jdbc:postgresql://localhost:5432/sample";
	private static final String username = "postgres";
	private static final String password = "root";

	public static void main(String[] args) {

		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url, username, password);
			
			CallableStatement statement = connection.prepareCall("{? = call insertEmployee(?, ?, ?)}");
			
			statement.registerOutParameter(1, Types.INTEGER);
			statement.setInt(2, 105);
			statement.setString(3, "Tuz");
			statement.setInt(4, 1000);
			
			statement.executeUpdate(); // returns 0, if SP returns void.
			
			int rowsAffected = statement.getInt(1);
			
			System.out.println("Rows affected: " + rowsAffected);
			
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
