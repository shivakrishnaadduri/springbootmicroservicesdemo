package com.microservicesapp.api.ms.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {
	
	public String gererateUserId() {
		return UUID.randomUUID().toString();
	}

}
