package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

  @Autowired
  private MessageService messageService;

  @PostMapping
  public Message saveMessage(@RequestBody Message message) {
    return messageService.saveMessage(message);
  }

  @GetMapping("/{id}")
  public Message getMessage(@PathVariable String id) {
    return messageService.getMessage(id);
  }
}
