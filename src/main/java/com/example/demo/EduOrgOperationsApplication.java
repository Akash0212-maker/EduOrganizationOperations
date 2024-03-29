package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.edu.*") 
public class EduOrgOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduOrgOperationsApplication.class, args);
	}

}
