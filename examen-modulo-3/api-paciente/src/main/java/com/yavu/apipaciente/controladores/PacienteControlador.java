package com.yavu.apipaciente.controladores;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import com.yavu.apipaciente.modelos.PacienteModelo;
import com.yavu.apipaciente.modelos.ProfesionalModelo;
import com.yavu.apipaciente.modelos.TipoModelo;
import com.yavu.apipaciente.servicios.PacienteServicio;

@RestController
@CrossOrigin(origins = "*")
public class PacienteControlador {
	@Autowired
	PacienteServicio pacienteServicio;

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	@LoadBalanced
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

	@HystrixCommand(fallbackMethod = "fallbackMethod")
	@GetMapping("/profesional/{id}")
	public ProfesionalModelo getProfesional(@PathVariable Long id) {
		ProfesionalModelo profesional = restTemplate.getForObject("http://API.PROFESIONAL/profesional/" + id, ProfesionalModelo.class);

		return profesional;
	}

	@SuppressWarnings( "unused" )
	private ProfesionalModelo fallbackMethod(Long id) {
		TipoModelo idTipoModeloTemporal = new TipoModelo(id, "TIPO", "DESCRIPCION", true);

		LocalDate fechaNacimientoTemporal = LocalDate.of(2020, 9, 25);

		return new ProfesionalModelo(id, "NOMBRES", "APELLIDO PATERNO", "APELLIDO MATERNO", 1, true, idTipoModeloTemporal, fechaNacimientoTemporal);
	}
}
