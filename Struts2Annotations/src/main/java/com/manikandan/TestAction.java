package com.manikandan;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

@Action(
	value = "/testAction",
	results = {
		@Result(name = "success", location = "/success.jsp"),
		@Result(name = "error", location = "/error.jsp")
	}
)
//@Results({
//	@Result(name = "success", location = "/success.jsp"),
//	@Result(name = "error", location = "/error.jsp")
//})
public class TestAction extends ActionSupport {

	@Action("/testAction")
	@Override
	public String execute() throws Exception {
		System.out.println("TestAction.execute() method is called");
		return "success";
	}

}
