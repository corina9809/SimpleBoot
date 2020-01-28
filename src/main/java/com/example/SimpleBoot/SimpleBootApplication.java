package com.example.SimpleBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleBootApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringApplication.class);
		springApplication.setAdditionalProfiles("dev");

		springApplication.run(SimpleBootApplication.class,args);
	}


}
