package com.yavu.apiprofesional.servicios;

import java.util.List;
import java.util.Optional;

import com.yavu.apiprofesional.modelos.ProfesionalModelo;

public interface ProfesionalServicio {
	ProfesionalModelo guardarProfesional(ProfesionalModelo profesional);
	
	String eliminarProfesional(Long id);
	
	Optional<ProfesionalModelo> actualizarProfesional(Long id, ProfesionalModelo profesional);
	
	Optional<ProfesionalModelo> obtenerProfesional(Long id);
	
	List<ProfesionalModelo> listaProfesionales();
}
