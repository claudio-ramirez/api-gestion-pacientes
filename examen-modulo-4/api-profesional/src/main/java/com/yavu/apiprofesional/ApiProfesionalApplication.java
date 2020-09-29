package com.yavu.apiprofesional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiProfesionalApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiProfesionalApplication.class, args);
	}
}
