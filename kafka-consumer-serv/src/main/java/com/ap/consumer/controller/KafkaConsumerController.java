package com.ap.consumer.controller;

import com.ap.consumer.pojo.Message;
import com.ap.consumer.service.KafkaConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaConsumerController {

//    private final KafkaConsumerService kafkaConsumerService;
//
//    @Autowired
//    public KafkaConsumerController(KafkaConsumerService kafkaConsumerService) {
//        this.kafkaConsumerService = kafkaConsumerService;
//    }
    @Autowired
    KafkaConsumerService kafkaConsumerService;

    // 获取特定主题的最后10条消息  
    @GetMapping("/messages/{topic}")
    public ResponseEntity<List<Message>> getLastMessages(@PathVariable String topic) {
        List<Message> messages = kafkaConsumerService.getLastMessages(topic);
        return ResponseEntity.ok(messages);
    }
}