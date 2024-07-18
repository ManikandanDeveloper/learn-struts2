package com.manikandan.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.manikandan.dao.ProductDAO;
import com.manikandan.pojo.Product;
import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport {

	private List<Product> products;
	private String productName;
	private String productCategory;
	private Date createdDate;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	public void initProducts() {
		System.out.println("******** Filter Data *****");
		System.out.println(productName);
		System.out.println(productCategory);
		System.out.println(createdDate);
		
		String formattedDate = null;
		if (createdDate != null) {
			formattedDate = dateFormat.format(createdDate);
			System.out.println(formattedDate);
		}
		
		this.products = ProductDAO.findAll(productName, productCategory, formattedDate);
	}
	
	@Override
	public String execute() throws Exception {
		initProducts();

		return "success";
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
