package com.feastfreedom.feastfreedom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class FeastFreedomApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeastFreedomApplication.class, args);
	}
	
	// testing pushing from local branch add your name below
	// Rishabh
	// Sabareesh
	// Mostafa

}
