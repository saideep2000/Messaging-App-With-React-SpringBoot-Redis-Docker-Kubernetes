package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  private static final String MESSAGE_KEY_PREFIX = "message:";
  private final RedisTemplate<String, Object> redisTemplate;

  @Autowired
  public MessageService(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public void saveMessage(String id, String content) {
    redisTemplate.opsForValue().set(MESSAGE_KEY_PREFIX + id, content);
  }

  public String getMessage(String id) {
    return (String) redisTemplate.opsForValue().get(MESSAGE_KEY_PREFIX + id);
  }
}
