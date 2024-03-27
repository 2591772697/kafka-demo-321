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
        ListenableFuture future0 = kafkaTemplate.send(topic, JSONObject.toJSONString(string));
        future0.addCallback(o -> log.info("kafka message was sent successfully：" + JSONObject.toJSONString(string))
                , throwable -> log.error("kafka消息发送失败：" + JSONObject.toJSONString(string)));
//        用print直接打印
//        ListenableFuture future = kafkaTemplate.send(topic, string);
//        future.addCallback(o -> System.out.println("kafka message was sent successfully：" + JSONObject.toJSONString(string))
//                , throwable -> System.out.println("kafka消息发送失败：" + JSONObject.toJSONString(string)));

    }

    /**
     * 容器启动完成后，将生成测试数据
     */
    @Override
    public void run(String... args) {
        for (int i = 1; i < 11; i++) {
            send("hello world! 你好啊，这是第" + i+"条消息");
        }

    }

}