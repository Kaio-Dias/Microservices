package br.com.ey.gatewaylb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayLbApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayLbApplication.class, args);
	}

}
