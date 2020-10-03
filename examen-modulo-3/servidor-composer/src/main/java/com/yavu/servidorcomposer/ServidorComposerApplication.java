package com.yavu.servidorcomposer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ServidorComposerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServidorComposerApplication.class, args);
	}
}
