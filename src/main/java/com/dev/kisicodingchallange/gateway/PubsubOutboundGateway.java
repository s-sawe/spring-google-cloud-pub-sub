package com.dev.kisicodingchallange.gateway;


import org.springframework.integration.annotation.MessagingGateway;

//@MessagingGateway(defaultRequestChannel = "pubsubOutputChannel")
@MessagingGateway(name = "myPubSubGateway", defaultRequestChannel = "outboundMsgChannel")
public interface PubsubOutboundGateway {

    void sendToMyPubSub(String message);


}
