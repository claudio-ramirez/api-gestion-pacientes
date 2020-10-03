package com.yavu.apicalendario.servicios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yavu.apicalendario.modelos.CalendarioModelo;
import com.yavu.apicalendario.productores.EventSenderMessageProductor;
import com.yavu.apicalendario.repositorios.CalendarioRepositorio;

@Service
public class CalendarioImplementacion implements CalendarioServicio {
	@Autowired
	CalendarioRepositorio calendarioRepositorio;

	@Autowired
	private EventSenderMessageProductor eventSenderMessageProductor;

	@Override
	public CalendarioModelo guardarCalendario( CalendarioModelo calendario ) {
		eventSenderMessageProductor.sendMessage1( calendario );

		return calendarioRepositorio.save( calendario );
	}
	
	@Override
	public String eliminarCalendario( Long id ) {
		if(id != null) {
			Boolean result = calendarioRepositorio.existsById(id);

			if(result) {
				calendarioRepositorio.deleteById(id);

				return "Eliminado exitosamente";
			}

			return "Id no válido";
		}

		return "Proporcione un id";	
	}

	@Override
	public Optional< CalendarioModelo > actualizarCalendario( Long id, CalendarioModelo calendario ) {
		Optional< CalendarioModelo > calendarioActualizado = calendarioRepositorio.findById(id);

		if (calendarioActualizado.isPresent()) {
			CalendarioModelo _calendario = calendarioActualizado.get();

			_calendario.setFecha( calendario.getFecha() );
			_calendario.setHora( calendario.getHora() );
			_calendario.setDisponible( calendario.isDisponible() );

			calendarioRepositorio.save(_calendario);
		}

		return calendarioActualizado;
	}

	@Override
	public Optional<CalendarioModelo> obtenerCalendario( Long id ) {
		Optional<CalendarioModelo> calendario = calendarioRepositorio.findById(id);

		return calendario;
	}

	@Override
	public Optional< CalendarioModelo > obtenerCalendarioPorFechaHora( LocalDate fecha, Integer hora ) {
		Optional< CalendarioModelo > calendario = calendarioRepositorio.obtenerCalendarioPorFechaHora( fecha, hora );

		return calendario;
	}

	@Override
	public List< CalendarioModelo > listaCalendarios() {
		List<CalendarioModelo> calendarios = calendarioRepositorio.findAll();

		return calendarios;
	}
}
