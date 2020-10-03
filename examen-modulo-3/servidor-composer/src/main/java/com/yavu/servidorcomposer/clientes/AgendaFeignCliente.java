package com.yavu.servidorcomposer.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yavu.servidorcomposer.modelos.AgendaModelo;

@FeignClient(name = "api-agenda")
public interface AgendaFeignCliente {
	@GetMapping("/agenda/{id}")
	public AgendaModelo getAgenda(@PathVariable Long id);
}
