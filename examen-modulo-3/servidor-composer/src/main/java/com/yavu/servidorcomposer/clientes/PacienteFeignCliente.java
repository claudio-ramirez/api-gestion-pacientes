package com.yavu.servidorcomposer.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yavu.servidorcomposer.modelos.PacienteModelo;

@FeignClient(name = "api-paciente")
public interface PacienteFeignCliente {
	@GetMapping("/paciente/{id}")
	public PacienteModelo getPaciente(@PathVariable Long id);
}
