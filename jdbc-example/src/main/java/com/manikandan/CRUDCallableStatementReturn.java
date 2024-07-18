package com.manikandan;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDCallableStatementReturn {

	private static final String url = "jdbc:postgresql://localhost:5432/sample";
	private static final String username = "postgres";
	private static final String password = "root";

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			
			CallableStatement statement = connection.prepareCall("{call getEmployeeById(?)}");
			
			statement.setInt(1, 102);
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				Integer salary = resultSet.getInt("salary");
				
				System.out.printf("[name=%s, salary=%s]\n", name, salary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
