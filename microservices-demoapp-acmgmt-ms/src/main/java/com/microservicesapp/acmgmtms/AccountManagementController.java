package com.microservicesapp.acmgmtms;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accountManagement")
public class AccountManagementController {

	@GetMapping
	public String diplayGreeting() {
		
		return "Welcome to account Management page";
	}
	
}
