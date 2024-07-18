package com.manikandan.product.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

// Name space is created automatically by struts when the package structure is like 'actions.module'.
// Explicit Name space declaration is required when the structure is 'module.actions'
// Explicit Name space declarations can be done on class level and package level.
//@Namespace("/product") // used package-level declaration.
@Action(value = "/getDetails")
@ResultPath("/view")
@Result(name = "success", location = "product.jsp")
public class ProductDetailsAction {

	public String execute() {
		System.out.println("ProductDetailsAction.execute() is called");
		return "success";
	}
}
