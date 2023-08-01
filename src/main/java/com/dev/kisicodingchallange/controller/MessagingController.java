package com.dev.kisicodingchallange.controller;

import com.dev.kisicodingchallange.gateway.PubsubOutboundGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Component
@RestController @RequestMapping("/api/v1/") @Slf4j
public class MessagingController {

    @Autowired
    PubsubOutboundGateway messagingGateway;

    @PostMapping("send-message")
    public RedirectView sendMessageToGCP(@RequestBody String message){ //@RequestParam("message")
        log.info("----------------------- Reaches Controller -----------------------------");
        messagingGateway.sendToMyPubSub(message);
        return new RedirectView("/");
    }

    @PostMapping("publish-message")
    public String publishMessageToGCP(@RequestBody String message){
        messagingGateway.sendToMyPubSub(message);
        return "Message Published to PubSub Successfully";
    }
}
