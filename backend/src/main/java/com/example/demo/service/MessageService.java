package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MessageService {

  private static final String MESSAGE_KEY_PREFIX = "message:";
  private final Map<String, String> messageStore = new HashMap<>();

  public void saveMessage(String id, String content) {
    messageStore.put(MESSAGE_KEY_PREFIX + id, content);
  }

  public String getMessage(String id) {
    return messageStore.get(MESSAGE_KEY_PREFIX + id);
  }
}
