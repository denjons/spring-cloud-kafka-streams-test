package com.denjons.ksd.producer.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @Autowired
    private KafkaTemplate<String, String> template;

    @GetMapping("/producer/{value}")
    public String produce(@PathVariable String value){
        template.send("test", value);
        return "ok";
    }
}
