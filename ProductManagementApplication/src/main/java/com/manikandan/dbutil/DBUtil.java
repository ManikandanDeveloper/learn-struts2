package com.manikandan.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBUtil {

	private static final String url = "jdbc:postgresql://localhost:5432/sample";
	private static final String username = "postgres";
	private static final String password = "root";

	private DBUtil() {
	}

	public static Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, username, password);
//			System.out.println("Connection is obtained successfully.");
		} catch (SQLException e) {
			System.out.println("Unable to obtain connection.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to find org.postgresql.Driver");
			e.printStackTrace();
		}

		return connection;
	}

	public static void closeConnection(Connection connection) {
		try {
			connection.close();
//			System.out.println("Connection has been successfully closed.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
