//package com.ap.consumer.listener;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
///**
// * kafka consumer
// **/
//@Component
//@Slf4j
//public class KafkaConsumer {
//
//    @KafkaListener(topics = "${kafka.topic.name}")
//    public void listen(ConsumerRecord<?, ?> record) {
//        log.info("consumption arrived :topic={}, offset={}, message={}", record.topic(), record.offset(), record.value());
//    }
//
//
//}
//