package com.microservicesapp.api.ms.userservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicesapp.api.ms.shared.Utils;
import com.microservicesapp.api.ms.ui.model.request.UserDetailsRequestModel;
import com.microservicesapp.api.ms.ui.model.response.UserRest;
import com.microservicesapp.api.ms.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	Map<String,UserRest> userMap= new HashMap<String,UserRest>();
	Utils utils;
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils=utils; 
	}
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest userObjReturn = new UserRest();
		userObjReturn.setFirstName(userDetails.getFirstName());
		userObjReturn.setLastName(userDetails.getLastName());
		userObjReturn.setEmail(userDetails.getEmail());
		if(userDetails.getUserId().isEmpty()) {
			userObjReturn.setUserId(utils.gererateUserId());
		}else {
		userObjReturn.setUserId(userDetails.getUserId());
		}
		userObjReturn.setMessage("Please use userId to login the system");
		
		userMap.put(userDetails.getUserId(), userObjReturn);
		
		return userObjReturn;
	}

}
