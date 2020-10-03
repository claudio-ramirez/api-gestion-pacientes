package com.yavu.apicalendario.configuraciones;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yavu.apicalendario.productores.EventSenderMessageProductor;

@Configuration
public class EventProductorConfiguracion {
	@Bean
	DirectExchange directExchange() {
		return new DirectExchange("exchange-yavu");
	}

	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate rabbitTemp(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		return rabbitTemplate;
	}

	@Bean
	public EventSenderMessageProductor eventSenderMessageProductor() {
		return new EventSenderMessageProductor();
	}
}
