package com.manikandan.pojo;

public class Product {

	private String productId;
	private String name;
	private String category;
	private Integer price;
	private String createdDate;

	public Product() {
	}

	public Product(String productId, String name, String category, Integer price, String createdDate) {
		super();
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", price=" + price
				+ ", createdDate=" + createdDate + "]";
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
