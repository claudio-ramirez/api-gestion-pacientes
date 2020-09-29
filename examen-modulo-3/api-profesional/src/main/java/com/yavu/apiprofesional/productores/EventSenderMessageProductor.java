package com.yavu.apiprofesional.productores;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Autowired;

import com.yavu.apiprofesional.modelos.ProfesionalModelo;

public class EventSenderMessageProductor {
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Autowired
	private DirectExchange directExchange;

	public EventSenderMessageProductor() {}

	public void sendMessage(ProfesionalModelo profesional) {
		amqpTemplate.convertAndSend(directExchange.getName(), "profesional.created", profesional);
	}
}
