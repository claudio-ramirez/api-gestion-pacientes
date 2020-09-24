package com.yavu.apiprofesional.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yavu.apiprofesional.modelos.ProfesionalModelo;
import com.yavu.apiprofesional.repositorios.ProfesionalRepositorio;

@Service
public class ProfesionalImplementacion implements ProfesionalServicio {
	@Autowired
	ProfesionalRepositorio profesionalRepositorio;

	@Override
	public ProfesionalModelo guardarProfesional(ProfesionalModelo profesional) {
		return profesionalRepositorio.save(profesional);
	}

	@Override
	public String eliminarProfesional(Long id) {
		if(id != null) {
			Boolean result = profesionalRepositorio.existsById(id);

			if(result) {
				profesionalRepositorio.deleteById(id);

				return "Eliminado exitosamente";
			}

			return "Id no válido";
		}

		return "Proporcione un id";	
	}

	@Override
	public Optional<ProfesionalModelo> actualizarProfesional(Long id, ProfesionalModelo profesional) {
		Optional<ProfesionalModelo> profesionalActualizado = profesionalRepositorio.findById(id);

		if (profesionalActualizado.isPresent()) {
			ProfesionalModelo _profesional = profesionalActualizado.get();

			_profesional.setNombres(profesional.getNombres());
			_profesional.setApellidoPaterno(profesional.getApellidoPaterno());
			_profesional.setApellidoMaterno(profesional.getApellidoMaterno());
			_profesional.setExperiencia(profesional.getExperiencia());
			_profesional.setVigente(profesional.getVigente());
			_profesional.setFechaNacimiento(profesional.getFechaNacimiento());
			_profesional.setIdTipo(profesional.getIdTipo());

			profesionalRepositorio.save(_profesional);
		}

		return profesionalActualizado;
	}

	@Override
	public Optional<ProfesionalModelo> obtenerProfesional(Long id) {
		Optional<ProfesionalModelo> profesional = profesionalRepositorio.findById(id);

		return profesional;
	}

	@Override
	public List<ProfesionalModelo> listaProfesionales() {
		List<ProfesionalModelo> profesionales = profesionalRepositorio.findAll();

		return profesionales;
	}
}
