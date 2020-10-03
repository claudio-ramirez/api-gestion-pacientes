package com.yavu.servidorcomposer.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yavu.servidorcomposer.compositores.AgendaNuevaCompositor;
import com.yavu.servidorcomposer.modelos.AgendaNuevaModelo;

@RestController
public class ComposerControlador {
	@Autowired
	private AgendaNuevaCompositor agendaNuevaCompositor;

	@GetMapping("/agenda-entidades/{id}")
	public AgendaNuevaModelo obtenerAgenda( @PathVariable Long id ){
		return agendaNuevaCompositor.construirAgendaNueva( id );
	}
}
