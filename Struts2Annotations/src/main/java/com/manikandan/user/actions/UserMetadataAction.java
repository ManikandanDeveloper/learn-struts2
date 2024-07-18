package com.manikandan.user.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Action(value = "/getMetadata")
@Result(name = "success", location = "/namespace.jsp")
public class UserMetadataAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		System.out.println("UserMetadataAction.execute() is called");
		return "success";
	}

}
