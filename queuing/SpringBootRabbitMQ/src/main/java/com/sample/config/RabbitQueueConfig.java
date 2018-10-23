package com.sample.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitQueueConfig {

    private static final String exchange = "the-exchange";

    @Bean(name = "my-queue")
    Queue myQueue() {
        return new Queue("q1", true, false, false, null);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        final CachingConnectionFactory localhost = new CachingConnectionFactory();
        localhost.setAddresses("localhost:5672");
        return localhost;
    }

    @Bean
    TopicExchange channelExchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    Binding bindingMyQueue() {
        return BindingBuilder.bind(myQueue()).to(channelExchange()).with("my.routing.key");
    }

}
