package com.yavu.servidorcomposer.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yavu.servidorcomposer.clientes.AgendaFeignCliente;
import com.yavu.servidorcomposer.modelos.AgendaModelo;

@Service
public class AgendaImplementacion implements AgendaServicio {
	@Autowired
	private AgendaFeignCliente agendaFeignCliente;

	@Override
	public AgendaModelo obtenerAgenda( Long id ) {
		return agendaFeignCliente.getAgenda( id );
	}
}
