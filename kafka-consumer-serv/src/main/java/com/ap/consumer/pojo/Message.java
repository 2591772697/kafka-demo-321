package com.ap.consumer.pojo;

// 简单的消息类，用于存储消息内容和接收时间
public class Message {
    private String content;
    private String formattedTimestamp; // 使用字符串来存储格式化后的时间戳

    public Message(String content, String formattedTimestamp) {
        this.content = content;
        this.formattedTimestamp = formattedTimestamp;
    }


    public String getContent() {
        return content;
    }

    public String getFormattedTimestamp() {
        return formattedTimestamp;
    }

}
