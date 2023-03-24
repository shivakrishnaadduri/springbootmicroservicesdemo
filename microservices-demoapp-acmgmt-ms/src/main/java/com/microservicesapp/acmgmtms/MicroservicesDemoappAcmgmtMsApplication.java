package com.microservicesapp.acmgmtms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicesDemoappAcmgmtMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesDemoappAcmgmtMsApplication.class, args);
	}

}
