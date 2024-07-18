package com.manikandan.interceptors;

import org.apache.struts2.ServletActionContext;

import com.manikandan.action.LoginAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		System.out.println("LoginInterceptor.destory() is called.");
	}

	@Override
	public void init() {
		System.out.println("LoginInterceptor.init() is called.");
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		if (actionInvocation.getAction() instanceof LoginAction) {
			return actionInvocation.invoke();
		}

		Object user = ServletActionContext.getRequest().getSession().getAttribute("loggedInUser");
		
		if (user == null) {
			return "input";
		}

		return actionInvocation.invoke();
	}

}
