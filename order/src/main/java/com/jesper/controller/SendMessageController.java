package com.jesper.controller;


import com.jesper.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;


    @GetMapping("/sendMessage")
    public void process(){
        Message<String> build = MessageBuilder.withPayload("now " + new Date()).build();
        streamClient.output().send(build);
    }
}
