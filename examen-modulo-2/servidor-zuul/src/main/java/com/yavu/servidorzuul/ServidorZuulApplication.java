package com.yavu.servidorzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.yavu.servidorzuul.filtros.PreFiltro1;
import com.yavu.servidorzuul.filtros.PreFiltro2;
import com.yavu.servidorzuul.filtros.PostFiltro;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ServidorZuulApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServidorZuulApplication.class, args);
	}

	@Bean
	public PreFiltro1 PreFiltro1() {
		return new PreFiltro1();
	}

	@Bean
	public PreFiltro2 PreFiltro2() {
		return new PreFiltro2();
	}

	@Bean
	public PostFiltro PostFiltro() {
		return new PostFiltro();
	}
}
