package com.microservicesapp.api.ms.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {

	@NotNull(message="FirstName can not be empty ")
	private String firstName;
	@NotEmpty(message="LastName can not be empty ")
	private String lastName;
	@NotEmpty(message="Email cannot be empty")
	@Email
	private String email;
	@NotEmpty(message="Password can not be empty ")
	@Size(min=8,max=16, message ="Password must be minimum of 8 characters and maximum of 16 characters")
	private String password;
	private String userId;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
