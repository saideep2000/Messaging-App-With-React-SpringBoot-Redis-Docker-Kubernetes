package com.example.demo.service;

import com.example.demo.model.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  public Message saveMessage(Message message) {
    // Mocking save functionality
    message.setContent("Saved message: " + message.getContent());
    return message;
  }

  public Message getMessage(String id) {
    // Mocking retrieval functionality
    return new Message(id, "This is a mock message");
  }
}
