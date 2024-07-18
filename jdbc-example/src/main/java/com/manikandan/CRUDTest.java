package com.manikandan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class CRUDTest {
	private static final String url = "jdbc:postgresql://localhost:5432/sample";
	private static final String username = "postgres";
	private static final String password = "root";

	public static void main(String[] args) {
		Connection connection = null;
		
		try {
			System.out.println("Initiating DB connection...");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection is obtained");
			
			Statement stmt = connection.createStatement();
			
//			int rowsAffected = stmt.executeUpdate("CREATE TABLE employee(emp_id int, name varchar(30), salary int)");
//			int rowsAffected = stmt.executeUpdate("INSERT INTO employee VALUES (3, 'Peter parker', 300)");
//			int rowsAffected = stmt.executeUpdate("UPDATE employee SET salary = 3000 WHERE emp_id = 3");
			int rowsAffected = stmt.executeUpdate("DELETE FROM employee WHERE emp_id = 3");
			
			System.out.println("Rows affected: " + rowsAffected);
			
		} catch (SQLException e) {
			System.out.println("Unable to obtain connection");
			e.printStackTrace();
		} finally {
			Optional.of(connection).ifPresent(conn -> {
				try {
					conn.close();
					System.out.println("Connection is closed.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
		}
	}
}
