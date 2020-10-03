package com.yavu.apiagenda.productores;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.yavu.apiagenda.modelos.AgendaModelo;

public class EventSenderMessageProductor {
	@Autowired
	private AmqpTemplate rabbitTemp;

	@Autowired
	private DirectExchange directExchange;

	public EventSenderMessageProductor() {}

	public void sendMessage( AgendaModelo agenda ) {
		rabbitTemp.convertAndSend( directExchange.getName(),"agenda.creada", agenda );
	}
}
