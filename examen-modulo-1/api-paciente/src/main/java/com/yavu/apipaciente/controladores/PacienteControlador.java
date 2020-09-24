package com.yavu.apipaciente.controladores;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yavu.apipaciente.clientes.ClientesEureka;
import com.yavu.apipaciente.modelos.PacienteModelo;
import com.yavu.apipaciente.modelos.ProfesionalModelo;
import com.yavu.apipaciente.servicios.PacienteServicio;

@RestController
public class PacienteControlador {
	@Autowired
	PacienteServicio pacienteServicio;

	@Autowired
	private ClientesEureka clientesEureka;
	
	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	@GetMapping(value = "/healthPaciente", produces = "application/json; charset=utf-8")
	public String getHealthCheck() {
		return "{ \"todoOk\" : true }";
	}

	@GetMapping("/pacientes")
	public List<PacienteModelo> getPacientes() {
		return pacienteServicio.listaPacientes();
	}

	@GetMapping("/paciente/{id}")
	public Optional<PacienteModelo> getPaciente(@PathVariable Long id) {
		return pacienteServicio.obtenerPaciente(id);
	}

	@PutMapping("/paciente/{id}")
	public Optional<PacienteModelo> updatePaciente(@RequestBody PacienteModelo paciente, @PathVariable Long id) {
		return pacienteServicio.actualizarPaciente(id, paciente);
	}

	@DeleteMapping(value = "/paciente/{id}")
	public HttpEntity<String> deletePaciente(@PathVariable Long id) {
		String resultado = pacienteServicio.eliminarPaciente(id);

		return new HttpEntity<String>(resultado);
	}

	@PostMapping("/paciente")
	public PacienteModelo addPaciente(@RequestBody PacienteModelo paciente) {
		return pacienteServicio.guardarPaciente(paciente);
	}
	
	@GetMapping("/profesional/{id}")
	public ProfesionalModelo getProfesional(@PathVariable Long id) {
		URI profesionalURI = clientesEureka.getUri("API.PROFESIONAL");

		ProfesionalModelo profesional = restTemplate.getForObject(profesionalURI.resolve("/profesional/" + id), ProfesionalModelo.class);
		
		return profesional;
	}
}
