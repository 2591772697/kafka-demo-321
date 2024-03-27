package com.ap.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
 
/**
 * kafka consumer
 **/
@Component
@Slf4j
public class KafkaConsumer {
 
    @KafkaListener(topics = "${kafka.topic.name}")
    public void listen(ConsumerRecord<?, ?> record) {
        log.info("consumption arrived :topic={}, offset={}, message={}", record.topic(), record.offset(), record.value());
//        直接打印这些信息
//        System.out.println("消费到了 consumption arrived :" +
//                "topic="+record.topic()+"," +
//                " offset="+record.offset()+"," +
//                " message="+record.value());
    }
 
 
}
 