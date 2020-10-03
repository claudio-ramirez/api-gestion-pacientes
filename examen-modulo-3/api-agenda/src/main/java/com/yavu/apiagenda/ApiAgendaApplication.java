package com.yavu.apiagenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.yavu.apiagenda.configuraciones.RibbonConfiguracion;

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "restTemplate", configuration = { RibbonConfiguracion.class })
@EnableCircuitBreaker
public class ApiAgendaApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiAgendaApplication.class, args);
	}
}
