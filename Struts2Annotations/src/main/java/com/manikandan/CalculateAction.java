package com.manikandan;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

public class CalculateAction {

	@Action(value = "/calculateEMI", results = { @Result(name = "success", location = "/success.jsp") })
	public String calculateEMI() throws Exception {
		System.out.println("calculateEMI() is called");
		return "success";
	}

	@Action(value = "/calculateInterestRate", results = { @Result(name = "success", location = "/success.jsp") })
	public String calculateInterestRate() throws Exception {
		System.out.println("calculateInterestRate() is called");
		return "success";
	}

	@Action(value = "/calculateIncomeTax", results = { @Result(name = "success", location = "/success.jsp") })
	public String calculateIncomeTax() throws Exception {
		System.out.println("calculateIncomeTax() is called");
		return "success";
	}
}
