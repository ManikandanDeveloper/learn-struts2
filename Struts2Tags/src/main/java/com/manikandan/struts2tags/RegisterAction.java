package com.manikandan.struts2tags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 1681284513608286744L;

	private String firstName;
	private String lastName;
	private String gender;
	private Integer age;
	private String email;
	private String address;
	private String selectedColor;
	private List<String> colors;
	private boolean subscription;
	private List<String> hobbies;
	private List<String> selectedHobbies;
	private List<Product> products;

	public String initializeFormFields() {
		initializeColors();
		initializeHobbies();
		initProducts();
		
		return "input";
	}

	private void initializeColors() {
		colors = new ArrayList<String>();
		colors.add("Red");
		colors.add("Green");
		colors.add("Blue");
	}
	
	private void initializeHobbies() {
		hobbies = Arrays.asList("Running", "Swimming", "Reading", "Songs");
	}
	
	private void initProducts() {
		this.products = new ArrayList<Product>();
		this.products.add(new Product(100, "Scale", 10));
		this.products.add(new Product(101, "Pencil", 5));
		this.products.add(new Product(102, "Eraser", 5));
	}

	/*
	@Override
	public void validate() {
		if (firstName.isEmpty()) {
			addFieldError("firstName", "First Name is required");
		}
		
		if (lastName.isEmpty()) {
			addFieldError("lastName", "Last Name is required");
		}
		
		if (gender == null) {
			addFieldError("gender", "Gender is required");
		}
		
		if (age == null) {
			addFieldError("age", "Age is required");
		} else if (age < 18) {
			addFieldError("age", "Age should be greater than 18");
		}
		
		if (email.isEmpty()) {
			addFieldError("email", "Email is required");
		}
	}
	*/

	public String execute() {
		System.out.println("RegisterAction.execute method is called");
		
		if (subscription) {
			System.out.println("You are a subscriber");
		}
		
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSelectedColor() {
		return selectedColor;
	}

	public void setSelectedColor(String selectedColor) {
		this.selectedColor = selectedColor;
	}

	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}

	public boolean isSubscription() {
		return subscription;
	}

	public void setSubscription(boolean subscription) {
		this.subscription = subscription;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public List<String> getSelectedHobbies() {
		return selectedHobbies;
	}

	public void setSelectedHobbies(List<String> selectedHobbies) {
		this.selectedHobbies = selectedHobbies;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
