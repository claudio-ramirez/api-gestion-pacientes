package com.yavu.apicalendario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApiCalendarioApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiCalendarioApplication.class, args);
	}
}
