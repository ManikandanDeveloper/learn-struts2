package com.manikandan.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Actions({
	@Action(value = "/testAction1", results = { @Result(name = "success", location = "/result1.jsp") }),
	@Action(value = "/testAction2", results = { @Result(name = "success", location = "/result2.jsp") })
	})
public class MultiURLAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		System.out.println("MultiURLAction.execute() is called");
		return "success";
	}

}
