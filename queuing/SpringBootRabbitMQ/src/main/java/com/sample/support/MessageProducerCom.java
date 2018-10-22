package com.sample.support;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class MessageProducerCom implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private static final String externalChannelExchange = "cmr-channel-exchange";

    @Autowired
    public MessageProducerCom(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @Override
    public void run(String... args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            String s = "{hello + " + System.currentTimeMillis() + "}";
            CorrelationData correlationData = new CorrelationData();
            correlationData.setId(System.currentTimeMillis() + "");
            rabbitTemplate.convertAndSend(externalChannelExchange, "webhook.channel.com", s, correlationData);
            System.out.println("sent " + s + " com");
        }
    }
}
