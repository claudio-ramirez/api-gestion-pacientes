package com.yavu.apicalendario.configuraciones;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

import com.yavu.apicalendario.consumidores.EventReceiverMessageConsumidor;

@Configuration
public class EventConsumidorConfiguracion implements RabbitListenerConfigurer {
	@Bean
	public DirectExchange eventExchange() {
		return new DirectExchange("exchange-yavu");
	}

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange( "exchange-yavu-rollback" );
	}

	@Bean
	public Queue queueRollback() {
		return new Queue( "rollback.calendario" );
	}

	@Bean
	public Binding bindingRollback( Queue queueRollback, TopicExchange topicExchange ) {
		return BindingBuilder.bind( queueRollback ).to( topicExchange ).with( "rollback.calendario" );
	}

	@Bean
	public Queue queue() {
		return new Queue( "calendario.creado" );
	}

	@Bean
	public Binding binding( Queue queue, DirectExchange eventExchange ) {
		return BindingBuilder.bind( queue ).to( eventExchange ).with( "calendario.creado" );
	}

	@Bean
	public Queue queue2() {
		return new Queue( "calendario.ocupado" );
	}

	@Bean
	public Binding binding2( Queue queue, DirectExchange eventExchange ) {
		return BindingBuilder.bind( queue ).to( eventExchange ).with( "calendario.ocupado" );
	}

	@Bean
	public EventReceiverMessageConsumidor eventReceiverMessageConsumidor() {
		return new EventReceiverMessageConsumidor();
	}

	@Override
	public void configureRabbitListeners( RabbitListenerEndpointRegistrar registrar ) {
		registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
	}

	@Bean
	MessageHandlerMethodFactory messageHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();

		messageHandlerMethodFactory.setMessageConverter( consumerJackson2MessageConverter() );

		return messageHandlerMethodFactory;
	}

	@Bean
	public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
		return new MappingJackson2MessageConverter();
	}
}
