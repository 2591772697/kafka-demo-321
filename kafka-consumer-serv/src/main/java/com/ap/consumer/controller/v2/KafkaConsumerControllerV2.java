package com.ap.consumer.controller.v2;

import com.ap.consumer.pojo.Message;
import com.ap.consumer.service.KafkaConsumerService;
import com.ap.consumer.service.KafkaConsumerServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer/v2")
public class KafkaConsumerControllerV2 {

    //    @Autowired
//    KafkaConsumerServiceV2 consumerServiceV2;
    @Autowired
    KafkaConsumerService consumerServiceV2;

    // 获取特定主题的最后10条消息  
    @GetMapping("/getLastMessages/{topic}")
    public ResponseEntity<List<Message>> getLastMessages(@PathVariable String topic) {
        List<Message> messageList = consumerServiceV2.getLastMessagesDesc(topic);
        return ResponseEntity.ok(messageList);
    }
}