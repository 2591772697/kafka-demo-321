package com.ap.consumer.pojo;

// 简单的消息类，用于存储消息内容和接收时间
public class Message {
    private String content;
    private String formattedTimestamp;
    private long timestamp; // 原始时间戳，单位是毫秒

    public Message(String content, String formattedTimestamp, long timestamp) {
        this.content = content;
        this.formattedTimestamp = formattedTimestamp;
        this.timestamp = timestamp;
    }

    public Message(String content, String formattedTimestamp) {
        this.content = content;
        this.formattedTimestamp = formattedTimestamp;
    }



    public long getTimestamp() {
        return timestamp;
    }


    public String getContent() {
        return content;
    }

    public String getFormattedTimestamp() {
        return formattedTimestamp;
    }



}
