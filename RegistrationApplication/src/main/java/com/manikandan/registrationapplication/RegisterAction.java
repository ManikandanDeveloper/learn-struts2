package com.manikandan.registrationapplication;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 1681284513608286744L;

	private String firstName;
	private String lastName;
	private String gender;
	private Integer age;
	private String email;

	@Override
	public void validate() {
		if (firstName.isEmpty()) {
			addFieldError("firstName", getText("error.required.firstName"));
		}
		
		if (lastName.isEmpty()) {
			addFieldError("lastName", getText("error.required.lastName"));
		}
		
		if (gender == null) {
			addFieldError("gender", getText("error.required.gender"));
		}
		
		if (age == null) {
			addFieldError("age", getText("error.required.age"));
		} else if (age < 18) {
			addFieldError("age", getText("error.range.age"));
		}
		
		if (email.isEmpty()) {
			addFieldError("email", getText("error.required.email"));
		}
	}

	public String execute() {
		System.out.println("RegisterAction.execute method is called");
		
		return "success";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
