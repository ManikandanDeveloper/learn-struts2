package com.manikandan.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		ServletActionContext.getRequest().getSession().invalidate();

		return "input";
	}

}
