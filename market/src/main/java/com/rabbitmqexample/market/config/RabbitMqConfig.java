package com.rabbitmqexample.market.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${sample.rabbitmq.exchange}")
    String exchangeCelil;

    @Value("${sample.rabbitmq.firstQueue}")
    String firstStepQueue;

    @Value("${sample.rabbitmq.secondQueue}")
    String secondQueue;

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchangeCelil);
    }

    @Bean
    Queue firstStepQueue() {
        return new Queue(firstStepQueue, true);
    }

    @Bean
    Queue secondStepQueue() {
        return new Queue(secondQueue, true);
    }

    @Bean
    Binding firstBinding(Queue firstStepQueue, DirectExchange exchange) {
        return BindingBuilder.bind(firstStepQueue).to(exchange).with("firstStepQueue");
    }

    @Bean
    Binding secondBinding(Queue secondStepQueue, DirectExchange exchange) {
        return BindingBuilder.bind(secondStepQueue).to(exchange).with("secondQueue"); // Bu routing key'i kontrol edin
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }
}


