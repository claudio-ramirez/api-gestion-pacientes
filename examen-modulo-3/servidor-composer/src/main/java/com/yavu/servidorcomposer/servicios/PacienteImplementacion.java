package com.yavu.servidorcomposer.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yavu.servidorcomposer.clientes.PacienteFeignCliente;
import com.yavu.servidorcomposer.modelos.PacienteModelo;

@Service
public class PacienteImplementacion implements PacienteServicio {
	@Autowired
	private PacienteFeignCliente pacienteFeignCliente;

	@Override
	public PacienteModelo obtenerPaciente( Long id ) {
		return pacienteFeignCliente.getPaciente( id );
	}
}
