package com.ap.consumer.pojo;

import lombok.Data;

// 简单的消息类，用于存储消息内容和接收时间
@Data
public class Message {
    private final String content;
    private final long timestamp;

    public Message(String content, long timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }


}