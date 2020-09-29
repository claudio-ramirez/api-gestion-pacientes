package com.yavu.apiagenda.consumidores;

import java.text.ParseException;
import java.util.Optional;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import com.yavu.apiagenda.modelos.AgendaModelo;
import com.yavu.apiagenda.modelos.AgendaPrimaryKey;
import com.yavu.apiagenda.modelos.CalendarioModelo;
import com.yavu.apiagenda.productores.EventSenderMessageProductor;
import com.yavu.apiagenda.repositorios.AgendaRepositorio;

public class EventReceiverMessageConsumidor {
	@Autowired
	private AgendaRepositorio agendaRepositorio;

	@Autowired
	private EventSenderMessageProductor eventSenderMessageProductor;

	@RabbitListener( queues = "agenda" )
	public void receive( CalendarioModelo calendarioModelo ) {
		try {
			AgendaModelo agendaModelo = new AgendaModelo( new AgendaPrimaryKey( calendarioModelo.getIdProfesional(), calendarioModelo.getIdPaciente() ), calendarioModelo.isDisponible(), calendarioModelo.getFecha(), calendarioModelo.getHora() );

			agendaRepositorio.save( agendaModelo );

			calendarioModelo.setDisponible(false);

			eventSenderMessageProductor.sendMessage( calendarioModelo );
		} catch ( ParseException e ) {
			e.printStackTrace();
		}
	}

	@RabbitListener( queues = "rollbackAgenda" )
	public void receiveRollback( CalendarioModelo calendarioModelo ) {
		Optional< AgendaModelo > agendaModelo = agendaRepositorio.findById( new AgendaPrimaryKey( calendarioModelo.getIdProfesional(), calendarioModelo.getIdPaciente() ) );

		agendaRepositorio.delete( agendaModelo.get() );
	}
}
