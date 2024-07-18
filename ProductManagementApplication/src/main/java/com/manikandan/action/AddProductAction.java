package com.manikandan.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.manikandan.dao.ProductDAO;
import com.manikandan.pojo.Product;
import com.opensymphony.xwork2.ActionSupport;

public class AddProductAction extends ActionSupport {
	
	private String productId;
	private String productName;
	private String productCategory;
	private Integer productPrice;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public String execute() throws Exception {
		String createdDate = dateFormat.format(new Date());

		Product product = new Product(productId, productName, productCategory, productPrice, createdDate);
		int result = ProductDAO.addProduct(product);

		if (result == 1) {
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

}
