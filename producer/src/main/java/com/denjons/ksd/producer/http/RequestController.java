package com.denjons.ksd.producer.http;

import com.denjons.ksd.producer.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @Autowired
    private Producer producer;

    @GetMapping("/producer/{value}")
    public String produce(@PathVariable String value){
        producer.getSource().output().send(MessageBuilder.withPayload(value).build());
        return "ok";
    }
}
