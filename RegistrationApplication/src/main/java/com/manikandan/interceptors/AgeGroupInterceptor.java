package com.manikandan.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class AgeGroupInterceptor implements Interceptor {

	@Override
	public void init() {
		System.out.println("AgeGroupInterceptor - Init method is called");
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		System.out.println("AgeGroupInterceptor - Pre-processing");

		ValueStack stack = actionInvocation.getStack();
		Integer age = (Integer) stack.findValue("age");

		String ageGroup;

		if (age < 18) {
			ageGroup = "Children";
		} else if (age < 50) {
			ageGroup = "Adult";
		} else {
			ageGroup = "Senior";
		}

		stack.set("age", String.format("%d (%s)", age, ageGroup));

		String result = actionInvocation.invoke();
		System.out.println("AgeGroupInterceptor - Post-processing");

		return result;
	}

	@Override
	public void destroy() {
		System.out.println("AgeGroupInterceptor - Destroy method is called");
	}
}
