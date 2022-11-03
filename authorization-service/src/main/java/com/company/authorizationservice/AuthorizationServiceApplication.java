package com.company.authorizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer //this snippet enables the resource server features for this application
public class AuthorizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServiceApplication.class, args);
	}

}
