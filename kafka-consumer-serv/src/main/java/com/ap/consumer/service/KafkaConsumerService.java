package com.ap.consumer.service;

import com.ap.consumer.pojo.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class KafkaConsumerService {

    private final ConcurrentHashMap<String, List<Message>> messages = new ConcurrentHashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    // 监听Topic A的消息
    @KafkaListener(topics = "topic-A", groupId = "my-group")
    public void listenTopicA(ConsumerRecord<?, ?> record) {
        String topic = record.topic();
        String message = (String) record.value();
        long timestamp = record.timestamp(); // 假设record.timestamp()提供了正确的时间戳
        processMessage(topic, message, timestamp);
    }


    // 监听Topic B的消息
    @KafkaListener(topics = "topic-B", groupId = "my-group")
    public void listenTopicB(ConsumerRecord<?, ?> record) {
        String topic = record.topic();
        String message = (String) record.value();
        long timestamp = record.timestamp(); // 假设record.timestamp()提供了正确的时间戳
        processMessage(topic, message, timestamp);
    }



    private void processMessage(String topic, String message, long timestamp) {
        String formattedTimestamp = convertTimestampToString(timestamp);
        List<Message> messageList = messages.computeIfAbsent(topic, k -> new LinkedList<>());
        messageList.add(new Message(message, formattedTimestamp));

        while (messageList.size() > 10) {
            messageList.remove(0);
        }
    }

    // 获取特定主题的最后10条消息
    public List<Message> getLastMessages(String topic) {
        return messages.getOrDefault(topic, new LinkedList<>());
    }

    // 辅助方法：将long类型时间戳转换为LocalDateTime
    private String convertTimestampToString(long timestamp) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss-yyyy/MM/dd");
        return dateTime.format(formatter);
    }


}