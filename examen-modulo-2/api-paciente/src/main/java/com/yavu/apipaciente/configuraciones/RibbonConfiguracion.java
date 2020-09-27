package com.yavu.apipaciente.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class RibbonConfiguracion {
	@Bean
	public IRule ribbonRule() {
		return new RoundRobinRule();
	}
}
