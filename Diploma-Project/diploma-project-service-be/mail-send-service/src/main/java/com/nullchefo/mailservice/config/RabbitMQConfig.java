package com.nullchefo.mailservice.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${rabbitmq.queue.name}")
	private String queue;

	@Value("${rabbitmq.exchange.name}")
	private String exchange;

	@Value("${rabbitmq.routing.key}")
	private String routingKey;


	@Bean
	public Queue jsonQueue(){
		return new Queue(queue);
	}

	// spring bean for rabbitmq exchange
	@Bean
	public TopicExchange exchange(){
		return new TopicExchange(exchange);
	}

	// binding between json queue and exchange using routing key
	@Bean
	public Binding jsonBinding(){
		return BindingBuilder
				.bind(jsonQueue())
				.to(exchange())
				.with(routingKey);
	}

	@Bean
	public MessageConverter converter(){
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;
	}


}
