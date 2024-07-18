package com.manikandan.product.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Action(value = "/getMetadata")
@Result(name = "success", location = "/namespace.jsp")
public class ProductMetadataAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		System.out.println("ProductMetadataAction.execute() is called");
		return "success";
	}

}
