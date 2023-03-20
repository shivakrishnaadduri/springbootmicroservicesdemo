package microservicesdemoappds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroservicesDemoappDsApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesDemoappDsApplication.class, args);
		System.out.println("Discovery server started.");
	}

}
