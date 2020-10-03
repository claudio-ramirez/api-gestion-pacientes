package com.yavu.apipaciente.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yavu.apipaciente.modelos.PacienteModelo;
import com.yavu.apipaciente.repositorios.PacienteRepositorio;

@Service
public class PacienteImplementacion implements PacienteServicio {
	@Autowired
	PacienteRepositorio pacienteRepositorio;

	@Override
	public PacienteModelo guardarPaciente(PacienteModelo paciente) {
		return pacienteRepositorio.save(paciente);
	}

	@Override
	public String eliminarPaciente(Long id) {
		if(id != null) {
			Boolean result = pacienteRepositorio.existsById(id);

			if(result) {
				pacienteRepositorio.deleteById(id);

				return "Eliminado exitosamente";
			}

			return "Id no válido";
		}

		return "Proporcione un id";	
	}

	@Override
	public Optional<PacienteModelo> actualizarPaciente(Long id, PacienteModelo paciente) {
		Optional<PacienteModelo> pacienteActualizado = pacienteRepositorio.findById(id);

		if (pacienteActualizado.isPresent()) {
			PacienteModelo _paciente = pacienteActualizado.get();

			_paciente.setNombres(paciente.getNombres());
			_paciente.setApellidoPaterno(paciente.getApellidoPaterno());
			_paciente.setApellidoMaterno(paciente.getApellidoMaterno());
			_paciente.setNumeroIdentificacion(paciente.getNumeroIdentificacion());
			_paciente.setVigente(paciente.getVigente());

			pacienteRepositorio.save(_paciente);
		}

		return pacienteActualizado;
	}

	@Override
	public Optional<PacienteModelo> obtenerPaciente(Long id) {
		Optional<PacienteModelo> paciente = pacienteRepositorio.findById(id);

		return paciente;
	}

	@Override
	public List<PacienteModelo> listaPacientes() {
		List<PacienteModelo> pacientes = pacienteRepositorio.findAll();

		return pacientes;
	}
}
