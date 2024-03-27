package com.ap.consumer.pojo.model;

import com.ap.consumer.pojo.Message;

import java.util.ArrayDeque;
import java.util.Deque;
  
public class MessageQueue {  
    // 假设这是你的消息队列  
    private Deque<Message> queue;
  
    public MessageQueue() {  
        this.queue = new ArrayDeque<>();
    }  
  
    public Message pollLast() {  
        return queue.pollLast(); // 从队列尾部移除并返回元素，如果队列为空则返回null  
    }  
}