package com.microservicesapp.api.ms.ui.model.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateUserDetailsRequestModel {

	@NotNull(message="FirstName can not be empty ")
	private String firstName;
	@NotEmpty(message="LastName can not be empty ")
	private String lastName;
	
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
	
	
	
}
