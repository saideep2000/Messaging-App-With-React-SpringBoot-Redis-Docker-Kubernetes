package com.example.demo.service;

import com.example.demo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  @Autowired
  private RedisTemplate<String, Message> redisTemplate;

  private static final String KEY = "Message";

  public Message saveMessage(Message message) {
    redisTemplate.opsForHash().put(KEY, message.getId(), message);
    return message;
  }

  public Message getMessage(String id) {
    return (Message) redisTemplate.opsForHash().get(KEY, id);
  }
}
