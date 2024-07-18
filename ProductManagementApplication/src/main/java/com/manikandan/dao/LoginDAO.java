package com.manikandan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.manikandan.dbutil.DBUtil;
import com.manikandan.pojo.LoginInfo;

public class LoginDAO {

	public static boolean isUserValid(LoginInfo userDetail) {
		boolean isValidUser = false;

		// Absence of getters and setters is the actual cause
		System.out.println("User Detail: " + userDetail);

		try {
			Connection conn = DBUtil.getConnection();
//			Statement statement = conn.createStatement();

//			ResultSet rs = statement.executeQuery("SELECT * FROM login_info WHERE username = '"
//					+ userDetail.getUsername() + "' AND password='" + userDetail.getPassword() + "'");
			
			PreparedStatement pStmt = conn.prepareStatement("SELECT * FROM login_info WHERE username=? AND password=?");
			pStmt.setString(1, userDetail.getUsername());
			pStmt.setString(2, userDetail.getPassword());
			
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				isValidUser = true;
			}
			
			DBUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isValidUser;
	}
}
