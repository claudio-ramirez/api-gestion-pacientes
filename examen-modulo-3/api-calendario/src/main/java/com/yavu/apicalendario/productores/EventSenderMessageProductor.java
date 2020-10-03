package com.yavu.apicalendario.productores;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.yavu.apicalendario.modelos.CalendarioModelo;

public class EventSenderMessageProductor {
	@Autowired
	private AmqpTemplate rabbitTemp;

	@Autowired
	private DirectExchange directExchange;

	@Autowired
	private TopicExchange topicExchange;

	public EventSenderMessageProductor() {}

	public void sendMessage1( CalendarioModelo calendario ) {
		rabbitTemp.convertAndSend( directExchange.getName(), "calendario.creado", calendario );
	}

	public void sendMessage2( String message ) {
		rabbitTemp.convertAndSend( directExchange.getName(), "calendario.ocupado", message );
	}

	public void sendMessageRollback( CalendarioModelo calendario ) {
		rabbitTemp.convertAndSend( topicExchange.getName(), "rollback.calendario", calendario );
	}
}
