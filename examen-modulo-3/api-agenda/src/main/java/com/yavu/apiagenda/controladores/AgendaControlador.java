package com.yavu.apiagenda.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yavu.apiagenda.modelos.AgendaModelo;
import com.yavu.apiagenda.servicios.AgendaServicio;

@RestController
@CrossOrigin(origins = "*")
public class AgendaControlador {
	@Autowired
	AgendaServicio agendaServicio;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	@GetMapping(value = "/healthAgenda", produces = "application/json; charset=utf-8")
	public String getHealthCheck() {
		return "{ \"todoOk\" : true }";
	}

	@GetMapping("/agendas")
	public List< AgendaModelo > getAgendas() {
		return agendaServicio.listaAgendas();
	}

	@GetMapping("/agenda/{id}")
	public Optional<AgendaModelo> getAgenda(@PathVariable Long id) {
		return agendaServicio.obtenerAgenda(id);
	}

	@PatchMapping("/agenda/{id}")
	public Optional<AgendaModelo> updateAgenda(@RequestBody AgendaModelo agenda, @PathVariable Long id) {
		return agendaServicio.actualizarAgenda(id, agenda);
	}

	@DeleteMapping(value = "/agenda/{id}")
	public HttpEntity<String> deleteAgenda(@PathVariable Long id) {
		String resultado = agendaServicio.eliminarAgenda(id);

		return new HttpEntity<String>(resultado);
	}

	@PostMapping("/agenda")
	public AgendaModelo addAgenda(@RequestBody AgendaModelo agenda) {
		return agendaServicio.guardarAgenda(agenda);
	}
}
