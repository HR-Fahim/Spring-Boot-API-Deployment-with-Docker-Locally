package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.demo") // Have to include the base package only

public class DemoApplication {

	public static void main(String[] args) {		SpringApplication.run(DemoApplication.class, args);
	}

}
