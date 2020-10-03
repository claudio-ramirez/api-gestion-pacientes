package com.yavu.servidorcomposer.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yavu.servidorcomposer.modelos.ProfesionalModelo;

@FeignClient(name = "api-profesional")
public interface ProfesionalFeignCliente {
	@GetMapping("/profesional/{id}")
	public ProfesionalModelo getProfesional(@PathVariable Long id);
}
