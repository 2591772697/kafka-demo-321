package com.ap.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * kafka producer
 **/
@Component
@Slf4j
public class KafkaProducer implements CommandLineRunner {

    //    @Resource
    @Autowired
    KafkaTemplate kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topic;

    /**
     * Send a Kafka message
     *
     * @param string
     */
    public void send(String string) {
        ListenableFuture future = kafkaTemplate.send(topic, JSONObject.toJSONString(string));
        //future.addCallback(o -> log.info("kafka message was sent successfully：" + jsonString), throwable -> log.error("kafka消息发送失败：" + jsonString));
    }

    /**
     * After the container startup is complete, the test data is produced
     */
    @Override
    public void run(String... args) {
        for (int i = 0; i < 10; i++) {
            send("hello world" + i);
        }
    }
}