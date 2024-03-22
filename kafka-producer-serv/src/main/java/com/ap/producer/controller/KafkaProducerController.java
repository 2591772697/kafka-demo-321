package com.ap.producer.controller;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.*;  
  
@RestController  
@RequestMapping("/sender")
public class KafkaProducerController {  
  
    @Autowired  
    private KafkaProducer<String, String> kafkaProducer;  
  
    @PostMapping("/send")
    public String sendMessageToKafka(@RequestParam String topic, @RequestParam String message) {  
        // 创建ProducerRecord  
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);  
  
        // 发送消息  
        kafkaProducer.send(record);  
  
        // 返回成功消息  
        return "Message sent to topic: " + topic;  
    }


}