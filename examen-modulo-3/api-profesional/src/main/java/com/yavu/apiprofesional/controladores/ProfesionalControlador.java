package com.yavu.apiprofesional.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yavu.apiprofesional.modelos.ProfesionalModelo;
import com.yavu.apiprofesional.servicios.ProfesionalServicio;

@RestController
public class ProfesionalControlador {
	@Autowired
	ProfesionalServicio profesionalServicio;

	@GetMapping(value = "/healthProfesional", produces = "application/json; charset=utf-8")
	public String getHealthCheck() {
		return "{ \"todoOk\" : true }";
	}

	@GetMapping("/profesionales")
	public List<ProfesionalModelo> getProfesionales() {
		return profesionalServicio.listaProfesionales();
	}

	@GetMapping("/profesional/{id}")
	public Optional<ProfesionalModelo> getProfesional(@PathVariable Long id) {
		return profesionalServicio.obtenerProfesional(id);
	}

	@PatchMapping("/profesional/{id}")
	public Optional<ProfesionalModelo> updateProfesional(@PathVariable Long id, @RequestBody ProfesionalModelo profesional) {
		return profesionalServicio.actualizarProfesional(id, profesional);
	}

	@DeleteMapping(value = "/profesional/{id}")
	public HttpEntity<String> deleteProfesional(@PathVariable Long id) {
		String resultado = profesionalServicio.eliminarProfesional(id);

		return new HttpEntity<String>(resultado);
	}

	@PostMapping("/profesional")
	public ProfesionalModelo addProfesional(@RequestBody ProfesionalModelo profesional) {
		return profesionalServicio.guardarProfesional(profesional);
	}
}
