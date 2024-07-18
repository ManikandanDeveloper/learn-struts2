package com.manikandan.action;

import com.manikandan.dao.ProductDAO;
import com.manikandan.pojo.Product;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateDataAction extends ActionSupport {
	
	private String productId;
	private String name;
	private String category;
	private Integer price;
	private String createdDate;

	@Override
	public String execute() throws Exception {
		Product product = ProductDAO.findById(productId);
		this.name = product.getName();
		this.category = product.getCategory();
		this.price = product.getPrice();
		this.createdDate = product.getCreatedDate();

		return "success";
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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

}
