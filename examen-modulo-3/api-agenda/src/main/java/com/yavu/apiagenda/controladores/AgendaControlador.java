package com.yavu.apiagenda.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.yavu.apiagenda.modelos.AgendaModelo;
import com.yavu.apiagenda.repositorios.AgendaRepositorio;

@RestController
public class AgendaControlador {
	@Autowired
	AgendaRepositorio agendarRepositorio;

	@GetMapping( "/agenda/usuario/{idUsuario}" )
	public List< AgendaModelo > getAgendaUsuario( @PathVariable Long idUsuario ) {
		return agendarRepositorio.obtenerAgendaPorPaciente( idUsuario );
	}
}
