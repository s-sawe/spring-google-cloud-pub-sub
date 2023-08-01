package com.dev.kisicodingchallange.gcp.publisher;


import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class ProducerServiceActuator {

    @Bean
    @ServiceActivator(inputChannel = "outboundMsgChannel")
    public PubSubMessageHandler messageSender(PubSubTemplate pubsubTemplate){

        return new PubSubMessageHandler(pubsubTemplate, "pubsubMessaging");

    }

}
