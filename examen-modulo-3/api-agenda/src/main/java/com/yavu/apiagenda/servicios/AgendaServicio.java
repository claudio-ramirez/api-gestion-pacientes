package com.yavu.apiagenda.servicios;

import java.util.List;
import java.util.Optional;

import com.yavu.apiagenda.modelos.AgendaModelo;

public interface AgendaServicio {
	AgendaModelo guardarAgenda(AgendaModelo agenda);

	String eliminarAgenda(Long id);

	Optional< AgendaModelo > actualizarAgenda(Long id, AgendaModelo agenda);

	Optional< AgendaModelo > obtenerAgenda(Long id);

	List< AgendaModelo > listaAgendas();
}
