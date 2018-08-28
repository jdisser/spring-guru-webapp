package com.altocirrusapps.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.altocirrusapps.spring5webapp.models", "com.altocirrusapps.spring5webapp.bootstrap", "com.altocirrusapps.spring5webapp.repositories"})
public class Spring5webappApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5webappApplication.class, args);
	}
}
