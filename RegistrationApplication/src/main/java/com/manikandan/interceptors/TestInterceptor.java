package com.manikandan.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class TestInterceptor implements Interceptor {

	@Override
	public void init() {
		System.out.println("TestInterceptor - Init is called.");
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("TestInterceptor - Pre-processing...");
		
		String result = actionInvocation.invoke();
		
		System.out.println("TestInterceptor - Post-processing...");
		
		return result;
	}

	@Override
	public void destroy() {
		System.out.println("TestInterceptor - Destroy is called.");
	}
}
