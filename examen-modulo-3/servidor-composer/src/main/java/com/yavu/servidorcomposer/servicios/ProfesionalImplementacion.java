package com.yavu.servidorcomposer.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yavu.servidorcomposer.clientes.ProfesionalFeignCliente;
import com.yavu.servidorcomposer.modelos.ProfesionalModelo;

@Service
public class ProfesionalImplementacion implements ProfesionalServicio {
	@Autowired
	private ProfesionalFeignCliente profesionalFeignCliente;

	@Override
	public ProfesionalModelo obtenerProfesional( Long id ) {
		return profesionalFeignCliente.getProfesional( id );
	}
}
