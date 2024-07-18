package com.manikandan.action;

import com.manikandan.dao.ProductDAO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport {
	
	private String productId;

	@Override
	public String execute() throws Exception {
		int rowsAffected = ProductDAO.deleteProduct(productId);

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

}
