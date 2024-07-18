package com.manikandan.action;

import org.apache.struts2.ServletActionContext;

import com.manikandan.dao.LoginDAO;
import com.manikandan.pojo.LoginInfo;

public class LoginAction {
	private String username;
	private String password;

	public String execute() {
		String statusCode;

		boolean isUserValid = LoginDAO.isUserValid(new LoginInfo(username, password));

		if (isUserValid) {
			ServletActionContext.getRequest().getSession().setAttribute("loggedInUser", username);
			statusCode = "success";
		} else {
			statusCode = "input";
		}

		return statusCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
