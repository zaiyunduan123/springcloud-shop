package com.jesper.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface StreamClient {

    @Input("myMessage")
    SubscribableChannel input();

    @Output("myMessage")
    MessageChannel output();

}
