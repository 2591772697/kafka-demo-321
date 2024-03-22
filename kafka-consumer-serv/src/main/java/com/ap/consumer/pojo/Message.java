package com.ap.consumer.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


// 简单的消息类，用于存储消息内容和接收时间
@Data
public class Message {
    private final String content;
    private final LocalDateTime timestamp;

    public Message(String content, LocalDateTime timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

    // 添加获取格式化时间戳的方法
    public String getFormattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss-yyyy/MM/dd");
        return timestamp.format(formatter);
    }
}