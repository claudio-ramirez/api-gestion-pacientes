package com.yavu.apiagenda.productores;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.yavu.apiagenda.modelos.CalendarioModelo;

@Configuration
public class EventSenderMessageProductor {
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Autowired
	private DirectExchange directExchange;

	@Autowired
	private TopicExchange topicExchange;

	public EventSenderMessageProductor() {}

	public void sendMessage( CalendarioModelo calendarioModelo ) {
		amqpTemplate.convertAndSend( directExchange.getName(), "yavu.agenda", calendarioModelo );
	}

	public void sendMessageRollback( CalendarioModelo calendarioModelo ) {
		amqpTemplate.convertAndSend( topicExchange.getName(), "rollback.calendario", calendarioModelo );
	}
}
