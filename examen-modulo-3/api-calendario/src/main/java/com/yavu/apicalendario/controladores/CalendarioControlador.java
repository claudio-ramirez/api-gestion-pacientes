package com.yavu.apicalendario.controladores;

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

import com.yavu.apicalendario.modelos.CalendarioModelo;
import com.yavu.apicalendario.servicios.CalendarioServicio;

@RestController
public class CalendarioControlador {
	@Autowired
	CalendarioServicio calendarioServicio;

	@GetMapping(value = "/healthCalendario", produces = "application/json; charset=utf-8")
	public String getHealthCheck() {
		return "{ \"todoOk\" : true }";
	}

	@GetMapping("/calendarios")
	public List< CalendarioModelo > getCalendarios() {
		return calendarioServicio.listaCalendarios();
	}

	@GetMapping("/calendario/{id}")
	public Optional<CalendarioModelo> getCalendario(@PathVariable Long id) {
		return calendarioServicio.obtenerCalendario(id);
	}

	@PatchMapping("/calendario/{id}")
	public Optional<CalendarioModelo> updateCalendario(@RequestBody CalendarioModelo calendario, @PathVariable Long id) {
		return calendarioServicio.actualizarCalendario(id, calendario);
	}

	@DeleteMapping(value = "/calendario/{id}")
	public HttpEntity<String> deleteCalendario(@PathVariable Long id) {
		String resultado = calendarioServicio.eliminarCalendario(id);

		return new HttpEntity<String>(resultado);
	}

	@PostMapping("/calendario")
	public CalendarioModelo addCalendario(@RequestBody CalendarioModelo calendario) {
		return calendarioServicio.guardarCalendario(calendario);
	}
}
