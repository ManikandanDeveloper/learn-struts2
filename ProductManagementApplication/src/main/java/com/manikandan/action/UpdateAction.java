package com.manikandan.action;

import com.manikandan.dao.ProductDAO;
import com.manikandan.pojo.Product;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {
	
	private String productId;
	private String name;
	private String category;
	private Integer price;

	@Override
	public String execute() throws Exception {
		Product product = new Product(productId, name, category, price, null);
		int rowsAffected = ProductDAO.updateProduct(product);
		
		if (rowsAffected == 1) {
			return "success";
		}
		
		return "error";
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
