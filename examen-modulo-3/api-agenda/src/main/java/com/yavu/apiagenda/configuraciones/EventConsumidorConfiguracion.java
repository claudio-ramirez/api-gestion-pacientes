package com.yavu.apiagenda.configuraciones;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

import com.yavu.apiagenda.consumidores.EventReceiverMessageConsumidor;

@Configuration
public class EventConsumidorConfiguracion implements RabbitListenerConfigurer {
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange("exchange-yavu-rollback");
	}

	@Bean
	public Queue queueRollback() {
		return new Queue("rollback.agenda");
	}

	@Bean
	public Binding bindingRollback(Queue queueRollback, TopicExchange topicExchange) {
		return BindingBuilder.bind(queueRollback).to(topicExchange).with("rollback.agenda");
	}

	@Bean
	public EventReceiverMessageConsumidor eventConsumer() {
		return new EventReceiverMessageConsumidor();
	}

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
	}

	@Bean
	MessageHandlerMethodFactory messageHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();

		messageHandlerMethodFactory.setMessageConverter(consumerJackson2MessageConverter());

		return messageHandlerMethodFactory;
	}

	@Bean
	public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
		return new MappingJackson2MessageConverter();
	}
}
