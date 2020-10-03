package com.yavu.apiagenda.consumidores;

import java.util.Optional;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import com.yavu.apiagenda.modelos.AgendaModelo;
import com.yavu.apiagenda.repositorios.AgendaRepositorio;

public class EventReceiverMessageConsumidor {
	@Autowired
	private AgendaRepositorio agendaRepositorio;

	@RabbitListener( queues = "rollback.agenda" )
	public void receiveRollback( AgendaModelo agenda ) {
		Optional< AgendaModelo > agendaModelo = agendaRepositorio.findById( agenda.getId() );

		agendaRepositorio.delete( agendaModelo.get() );
	}
}
