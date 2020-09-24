package com.yavu.apipaciente.servicios;

import java.util.List;
import java.util.Optional;

import com.yavu.apipaciente.modelos.PacienteModelo;

public interface PacienteServicio {
	PacienteModelo guardarPaciente(PacienteModelo paciente);
	
	String eliminarPaciente(Long id);
	
	Optional<PacienteModelo> actualizarPaciente(Long id, PacienteModelo paciente);
	
	Optional<PacienteModelo> obtenerPaciente(Long id);
	
	List<PacienteModelo> listaPacientes();
}
