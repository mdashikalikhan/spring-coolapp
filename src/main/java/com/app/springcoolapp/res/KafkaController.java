package com.app.springcoolapp.res;

import com.app.springcoolapp.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/sendtopc1")
    public String sendMessageToKafkaTopic() {
        kafkaProducerService.sendMessage("my-topic", "HI.....");
        return "Message sent to Kafka topic successfully!";
    }
}
