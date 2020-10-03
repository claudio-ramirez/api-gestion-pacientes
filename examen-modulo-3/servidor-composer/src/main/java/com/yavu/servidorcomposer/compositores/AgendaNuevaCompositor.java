package com.yavu.servidorcomposer.compositores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yavu.servidorcomposer.modelos.AgendaNuevaModelo;
import com.yavu.servidorcomposer.modelos.AgendaModelo;
import com.yavu.servidorcomposer.modelos.PacienteModelo;
import com.yavu.servidorcomposer.modelos.ProfesionalModelo;
import com.yavu.servidorcomposer.servicios.AgendaServicio;
import com.yavu.servidorcomposer.servicios.PacienteServicio;
import com.yavu.servidorcomposer.servicios.ProfesionalServicio;

@Component
public class AgendaNuevaCompositor {
	@Autowired
	private PacienteServicio pacienteServicio;

	@Autowired
	private ProfesionalServicio profesionalServicio;
	
	@Autowired
	private AgendaServicio agendaServicio;
	
	public AgendaNuevaModelo construirAgendaNueva( Long id ) {
		AgendaModelo agenda = agendaServicio.obtenerAgenda( id );

		PacienteModelo paciente = pacienteServicio.obtenerPaciente( agenda.getIdPaciente() );
		ProfesionalModelo profesional = profesionalServicio.obtenerProfesional( agenda.getIdProfesional() );

		AgendaNuevaModelo agendaNueva = new AgendaNuevaModelo();
		
		agendaNueva.setIdPaciente( paciente );
		agendaNueva.setIdProfesional( profesional );
		agendaNueva.setFechaAgenda( agenda.getFechaAgenda() );
		agendaNueva.setHoraAgenda( agenda.getHoraAgenda() );

		return agendaNueva;
	}
}
