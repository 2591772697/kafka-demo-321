package com.ap.consumer.service;

import com.ap.consumer.pojo.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class KafkaConsumerService {

    private final ConcurrentHashMap<String, List<Message>> messages = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong();

    // 监听Topic A的消息
    @KafkaListener(topics = "topic-A", groupId = "my-group")
    public void listenTopicA(ConsumerRecord<?, ?> record) {
        processMessage(record, "topic-A");
    }

    // 监听Topic B的消息
    @KafkaListener(topics = "topic-B", groupId = "my-group")
    public void listenTopicB(ConsumerRecord<?, ?> record) {
        System.out.println("record.topic().toString() = " + record.topic().toString());
        System.out.println("record.value().toString() = " + record.value().toString());
        processMessage(record, "topic-B");
    }

    private void processMessage(ConsumerRecord<?, ?> record, String topic) {
        String message = (String) record.value();
        messages.computeIfAbsent(topic, k -> new LinkedList<>()).add(new Message(message, System.currentTimeMillis()));
        // 保持只显示最后10条消息
        while (messages.get(topic).size() > 10) {
            messages.get(topic).remove(0);
        }
    }

    // 获取特定主题的最后10条消息
    public List<Message> getLastMessages(String topic) {
        return messages.getOrDefault(topic, new LinkedList<>());
    }


}