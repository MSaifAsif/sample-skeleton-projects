package com.sample.support;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MessageProducer implements CommandLineRunner {

    private static final String externalChannelExchange = "the-exchange";
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String s = "{hello + " + System.currentTimeMillis() + "}";
                CorrelationData correlationData = new CorrelationData();
                correlationData.setId(System.currentTimeMillis() + "");
                rabbitTemplate.convertAndSend(externalChannelExchange, "my.routing.key", s, correlationData);
                System.out.println("sent " + s);
            }
        }).start();

    }
}
