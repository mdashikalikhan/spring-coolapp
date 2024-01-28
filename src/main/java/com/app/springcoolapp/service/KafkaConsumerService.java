package com.app.springcoolapp.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void receiveMessage(String message) {
        // Process the received message
        System.out.println("Received message: " + message);
        // Perform further processing or actions here
    }
}
