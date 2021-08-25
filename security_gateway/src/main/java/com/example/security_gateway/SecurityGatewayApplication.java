package com.example.security_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SecurityGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityGatewayApplication.class, args);
	}
	

}
