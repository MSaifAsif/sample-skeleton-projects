package com.sample.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitQueueConfig {

    private static final String exchange = "the-exchange";

    @Bean(name = "my-queue-1")
    Queue queue() {
        return new Queue("my.queue.1", true, false, false);
    }

    @Bean
    TopicExchange channelExchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(channelExchange()).with("my.routing.key");
    }

}
