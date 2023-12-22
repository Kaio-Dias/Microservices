package br.com.ey.microservice.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.spring-framework.cloud.netflix.eureka.EnableEurekaClient; !!remove "-" from org.spring!!

@SpringBootApplication
@EnableDiscoveryClient
/*@EnableEurekaClient*/
public class PaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsApplication.class, args);
	}

}
