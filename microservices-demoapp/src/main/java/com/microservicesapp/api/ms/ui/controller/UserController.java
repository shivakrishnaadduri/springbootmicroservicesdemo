package com.microservicesapp.api.ms.ui.controller;




import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservicesapp.api.ms.ui.model.request.UpdateUserDetailsRequestModel;
import com.microservicesapp.api.ms.ui.model.request.UserDetailsRequestModel;
import com.microservicesapp.api.ms.ui.model.response.UserRest;
import com.microservicesapp.api.ms.userservice.UserService;

@RequestMapping("users")
@Controller
public class UserController {

	
	Map<String,UserRest> userMap= new HashMap<String,UserRest>();
	
	@Autowired
	UserService userService;

	@GetMapping(params = {"page","limit"})
	public String getUser(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "limit", defaultValue = "50") int limit) {
		return "This will give all the users information from page " + pageNumber + " with the limit of " + limit;
	}
	
	@GetMapping
	public String getAllUser() {
		return "This will give all the users information from page ";
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		//code snippet to test exception handling
		/*
		String lastName =null;
		
		int lengthOfLastName= lastName.length();
		try {
		String firstName=null;
		
		int lengthOfFristName= firstName.length();
		}catch(Exception e) {
			throw new UserServiceException("FristName cannot be empty");
		}
		*/
		if(userMap.containsKey(userId)) {
			return new ResponseEntity<UserRest>(userMap.get(userId), HttpStatus.OK);
		}
		return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		
		UserRest userObjReturn = userService.createUser(userDetails);
		return new ResponseEntity<UserRest>(userObjReturn, HttpStatus.OK);
	}

	
	@PutMapping(path="/{userId}",produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId, @RequestBody UpdateUserDetailsRequestModel updeteUserDetails) {
		
		if(userMap.containsKey(userId)) {
			UserRest existingUser=userMap.get(userId);
			existingUser.setFirstName(updeteUserDetails.getFirstName());
			existingUser.setLastName(updeteUserDetails.getLastName());
			userMap.put(userId,existingUser);
			return new ResponseEntity<UserRest>(userMap.get(userId), HttpStatus.OK);
		}
		
		 return new ResponseEntity<UserRest>(HttpStatus.OK);
	}

	@DeleteMapping(path="/{userId}",produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> deleteUser(@PathVariable String userId) {
		if(userMap.containsKey(userId)) {
			userMap.remove(userId);
			return new ResponseEntity<UserRest>(HttpStatus.OK);
		}
		return new ResponseEntity<UserRest>(HttpStatus.NOT_FOUND);
	}

}
