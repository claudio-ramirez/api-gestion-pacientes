package com.yavu.apicalendario.servicios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.yavu.apicalendario.modelos.CalendarioModelo;

public interface CalendarioServicio {
	CalendarioModelo guardarCalendario(CalendarioModelo calendario);

	String eliminarCalendario(Long id);

	Optional< CalendarioModelo > actualizarCalendario(Long id, CalendarioModelo calendario);

	Optional< CalendarioModelo > obtenerCalendario(Long id);

	Optional< CalendarioModelo > obtenerCalendarioPorFechaHora( LocalDate fecha, Integer hora );

	List< CalendarioModelo > listaCalendarios();
}
