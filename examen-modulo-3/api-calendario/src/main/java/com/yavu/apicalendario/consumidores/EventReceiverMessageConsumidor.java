package com.yavu.apicalendario.consumidores;

import java.util.Optional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.yavu.apicalendario.modelos.AgendaModelo;
import com.yavu.apicalendario.modelos.CalendarioModelo;
import com.yavu.apicalendario.productores.EventSenderMessageProductor;
import com.yavu.apicalendario.repositorios.CalendarioRepositorio;

public class EventReceiverMessageConsumidor {
	@Autowired
	private CalendarioRepositorio calendarioRepositorio;

	@Autowired
	private EventSenderMessageProductor eventSenderMessageProductor;

	@RabbitListener(queues="agenda.creada")
	public void receive( AgendaModelo agenda ) {
		try {
			Optional< CalendarioModelo > _buscarCalendario = calendarioRepositorio.obtenerCalendarioPorFechaHora( agenda.getFechaAgenda(), agenda.getHoraAgenda() );

			if( _buscarCalendario.isPresent() ) {
				eventSenderMessageProductor.sendMessage2( "Fecha y hora ocupadas, por favor intentelo de nuevo!" );
			} else {
				CalendarioModelo _calendario = new CalendarioModelo( agenda.getFechaAgenda(), agenda.getHoraAgenda(), true );

				calendarioRepositorio.save( _calendario );

				eventSenderMessageProductor.sendMessage1( _calendario );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	@RabbitListener(queues="rollback.calendario")
	public void receiveRollback( CalendarioModelo calendario ) {
		Optional< CalendarioModelo > _calendario = calendarioRepositorio.findById( calendario.getId() );

		calendarioRepositorio.delete( _calendario.get() );
	}
}
