package com.yavu.apipaciente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.yavu.apipaciente.configuraciones.RibbonConfiguracion;

@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name = "restTemplate", configuration = { RibbonConfiguracion.class })
@EnableCircuitBreaker
public class ApiPacienteApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiPacienteApplication.class, args);
	}
}
