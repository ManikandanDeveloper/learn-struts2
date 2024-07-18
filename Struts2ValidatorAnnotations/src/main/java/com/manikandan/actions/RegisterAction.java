package com.manikandan.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidationParameter;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Action("/registerAction")
@Results({
	@Result(name = "success", location = "/welcome.jsp"),
	@Result(name = "input", location = "/register.jsp")
})
// It's also possible to put all validations here using @Validations annotation.
public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 1681284513608286744L;

	private String firstName;
	private String lastName;
	private String gender;
	private Integer age;
	private String email;

//	@Override
//	public void validate() {
//		if (firstName.isEmpty()) {
//			addFieldError("firstName", getText("error.required.firstName"));
//		}
//		
//		if (lastName.isEmpty()) {
//			addFieldError("lastName", getText("error.required.lastName"));
//		}
//		
//		if (gender == null) {
//			addFieldError("gender", getText("error.required.gender"));
//		}
//		
//		if (age == null) {
//			addFieldError("age", getText("error.required.age"));
//		} else if (age < 18) {
//			addFieldError("age", getText("error.range.age"));
//		}
//		
//		if (email.isEmpty()) {
//			addFieldError("email", getText("error.required.email"));
//		}
//	}

	public String execute() {
		System.out.println("RegisterAction.execute method is called");
		
		return "success";
	}

	@RequiredStringValidator(
			type = ValidatorType.SIMPLE,
			fieldName = "firstName",
			message = "First name is required")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@RequiredStringValidator(
			type = ValidatorType.SIMPLE,
			fieldName = "lastName",
			message = "Last name is required")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@RequiredFieldValidator(
			type = ValidatorType.SIMPLE,
			fieldName = "gender",
			message = "Gender is required")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@RequiredFieldValidator(
			type = ValidatorType.SIMPLE,
			fieldName = "age",
			message = "Age is required")
	@IntRangeFieldValidator(
			type = ValidatorType.SIMPLE,
			fieldName = "age",
			min = "18",
			message = "Age should at least be 18")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@RequiredStringValidator(
			type = ValidatorType.SIMPLE,
			fieldName = "email",
			message = "Email is required")
	@EmailValidator(
			type = ValidatorType.SIMPLE,
			fieldName = "email",
			message = "Invalid email ID")
	@CustomValidator(
			type = "domainNameValidator",
			fieldName = "email",
			parameters = {
				@ValidationParameter(
						name = "domainName",
						value="gmail.com")
			},
			message = "Invalid Domain Name")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
