package com.manikandan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.manikandan.dbutil.DBUtil;
import com.manikandan.pojo.Product;

public class ProductDAO {

	private static Product toProduct(ResultSet resultSet) throws SQLException {
		String productId = resultSet.getString("product_id");
		String name = resultSet.getString("name");
		String category = resultSet.getString("category");
		Integer price = resultSet.getInt("price");
		String createdDate = resultSet.getString("created_date");

		return new Product(productId, name, category, price, createdDate);
	}
	
	public static List<Product> findAll() {
		List<Product> products = new ArrayList<>();

		Connection connection = DBUtil.getConnection();
		
		try (Statement stmt = connection.createStatement()) {
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM products");

			while (resultSet.next()) {
				products.add(toProduct(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBUtil.closeConnection(connection);

		return products;
	}
	
	public static List<Product> findAll(String name, String category, String createdDate) {
		StringBuilder sb = new StringBuilder("SELECT * FROM products");
		boolean isWhereAppended = false;
		boolean canAppendCondition = false;

		if (name != null && !name.isEmpty()) {
			if (!isWhereAppended) {
				sb.append(" WHERE");
				isWhereAppended = true;
			}

			sb.append(" name LIKE '%" + name + "%'");
			canAppendCondition = true;
		}
		
		if (category != null && !category.isEmpty()) {
			if (!isWhereAppended) {
				sb.append(" WHERE");
				isWhereAppended = true;
			}

			if (canAppendCondition) {
				sb.append(" AND");
				canAppendCondition = false;
			}
			
			sb.append(" category = '" + category + "'");
			canAppendCondition = true;
		}
		
		if (createdDate != null && !createdDate.isEmpty()) {
			if (!isWhereAppended) {
				sb.append(" WHERE");
				isWhereAppended = true;
			}
			
			if (canAppendCondition) {
				sb.append(" AND");
				canAppendCondition = false;
			}

			sb.append(" created_date = '" + createdDate + "'");
			canAppendCondition = true;
		}
		
		System.out.println("Final query: " + sb.toString());

		List<Product> products = new ArrayList<>();

		Connection connection = DBUtil.getConnection();
		
		try (Statement stmt = connection.createStatement()) {
			ResultSet resultSet = stmt.executeQuery(sb.toString());

			while (resultSet.next()) {
				products.add(toProduct(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBUtil.closeConnection(connection);

		return products;
	}
	
	public static int addProduct(Product product) {
		int status = 0;
		
		Connection connection = DBUtil.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO products VALUES (?, ?, ?, ?, ?)");
			statement.setString(1, product.getProductId());
			statement.setString(2, product.getName());
			statement.setString(3, product.getCategory());
			statement.setInt(4, product.getPrice());
			statement.setString(5, product.getCreatedDate());

			status = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static Product findById(String productId) {
		Product product = null;

		Connection connection = DBUtil.getConnection();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM products WHERE product_id=?");
			preparedStatement.setString(1, productId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) { // not using while, single result
				product = toProduct(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		DBUtil.closeConnection(connection);

		return product;
	}

	public static int updateProduct(Product product) {
		int status = 0;
		
		Connection connection = DBUtil.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE products SET name=?, category=?, price=? WHERE product_id=?");
			statement.setString(1, product.getName());
			statement.setString(2, product.getCategory());
			statement.setInt(3, product.getPrice());
			statement.setString(4, product.getProductId());

			status = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBUtil.closeConnection(connection);
		
		return status;
	}
	
	public static int deleteProduct(String productId) {
		int rowsAffected = 0;
		Connection connection = DBUtil.getConnection();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM products WHERE product_id=?");
			preparedStatement.setString(1, productId);

			rowsAffected = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsAffected;
	}
}
