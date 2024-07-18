package com.manikandan.user.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

//@Namespace("/user")
@Action(value = "/getDetails")
@ResultPath(value = "/view")
@Result(name = "success", location = "user.jsp")
public class UserDetailsAction {

	public String execute() {
		System.out.println("UserDetailsAction.execute() is called");
		return "success";
	}
}
