package com.dev.kisicodingchallange.controller;

import com.dev.kisicodingchallange.gateway.PubsubOutboundGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/api/v1/") @Slf4j
public class MessagingController {

    @Autowired
    private PubsubOutboundGateway messagingGateway;

    @PostMapping("publish-message")
    public String publishMessageToGCP(@RequestBody String message){
        messagingGateway.sendToMyPubSub(message);
        return "Message Published to PubSub Successfully";
    }

}
