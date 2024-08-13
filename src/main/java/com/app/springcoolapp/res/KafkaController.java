package com.app.springcoolapp.res;

import com.app.springcoolapp.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    /*@Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/sendtopc1")
    public String sendMessageToKafkaTopic() {
        kafkaProducerService.sendMessage("OTP", "01714113779,123456");
        kafkaProducerService.sendMessage("input-topic", "{name:Md. Ashik Ali Khan, name: Sabbir Rafit}");
        return "Message sent to Kafka topic successfully!";
    }*/
}
