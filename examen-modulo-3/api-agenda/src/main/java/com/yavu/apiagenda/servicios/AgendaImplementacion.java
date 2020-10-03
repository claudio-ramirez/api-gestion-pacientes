package com.yavu.apiagenda.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yavu.apiagenda.modelos.AgendaModelo;
import com.yavu.apiagenda.productores.EventSenderMessageProductor;
import com.yavu.apiagenda.repositorios.AgendaRepositorio;

@Service
public class AgendaImplementacion implements AgendaServicio {
	@Autowired
	AgendaRepositorio agendaRepositorio;

	@Autowired
	private EventSenderMessageProductor eventSenderMessageProductor;

	@Override
	public AgendaModelo guardarAgenda(AgendaModelo agenda) {
		eventSenderMessageProductor.sendMessage( agenda );

		return agendaRepositorio.save( agenda );
	}

	@Override
	public String eliminarAgenda(Long id) {
		if(id != null) {
			Boolean result = agendaRepositorio.existsById(id);

			if(result) {
				agendaRepositorio.deleteById(id);

				return "Eliminado exitosamente";
			}

			return "Id no válido";
		}

		return "Proporcione un id";	
	}

	@Override
	public Optional< AgendaModelo > actualizarAgenda(Long id, AgendaModelo agenda) {
		Optional< AgendaModelo > agendaActualizado = agendaRepositorio.findById(id);

		if (agendaActualizado.isPresent()) {
			AgendaModelo _agenda = agendaActualizado.get();

			_agenda.setIdPaciente(agenda.getIdPaciente());
			_agenda.setIdProfesional(agenda.getIdProfesional());
			_agenda.setFechaAgenda(agenda.getFechaAgenda());
			_agenda.setHoraAgenda(agenda.getHoraAgenda());

			agendaRepositorio.save(_agenda);
		}

		return agendaActualizado;
	}

	@Override
	public Optional<AgendaModelo> obtenerAgenda(Long id) {
		Optional<AgendaModelo> agenda = agendaRepositorio.findById(id);

		return agenda;
	}

	@Override
	public List< AgendaModelo > listaAgendas() {
		List<AgendaModelo> agendas = agendaRepositorio.findAll();

		return agendas;
	}
}
