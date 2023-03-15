package com.microservicesapp.api.ms.userservice;

import java.util.HashMap;
import java.util.Map;

import com.microservicesapp.api.ms.ui.model.request.UserDetailsRequestModel;
import com.microservicesapp.api.ms.ui.model.response.UserRest;

public interface UserService {
	
	
	
	public UserRest createUser(UserDetailsRequestModel userDetails);

}
