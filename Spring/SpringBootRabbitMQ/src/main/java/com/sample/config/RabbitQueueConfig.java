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

    public static final String externalChannelExchange = "cmr-channel-exchange";
    public static final String eventsExchange = "cmr-event-exchange";


    @Bean(name = "queue-bnb")
    Queue queueBnb() {
        return new Queue("listener.bnb", true, false, false);
    }

    @Bean(name = "queue-com")
    Queue queueCom() {
        return new Queue("listener.com", true, false, false);
    }

    @Bean(name = "queue-events")
    Queue queueEvents() {
        return new Queue("listener.events", true, false, false);
    }

    @Bean
    TopicExchange channelExchange() {
        return new TopicExchange(externalChannelExchange);
    }

    @Bean
    TopicExchange eventsExchange() {
        return new TopicExchange(eventsExchange);
    }

    @Bean
    Binding bindingBnb() {
        return BindingBuilder.bind(queueBnb()).to(channelExchange()).with("webhook.channel.bnb");
    }

    @Bean
    Binding bindingCom() {
        return BindingBuilder.bind(queueCom()).to(channelExchange()).with("webhook.channel.com");
    }

    @Bean
    Binding bindingEvents() {
        return BindingBuilder.bind(queueEvents()).to(eventsExchange()).with("webhook.push.events");
    }

}
