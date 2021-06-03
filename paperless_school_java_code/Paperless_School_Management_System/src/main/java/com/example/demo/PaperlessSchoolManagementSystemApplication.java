package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication

@Component
@ComponentScan(basePackages = "com.example.demo.*")
public class PaperlessSchoolManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaperlessSchoolManagementSystemApplication.class, args);
		
	}

}
