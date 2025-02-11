package com.example.dynamicdependency.controller;

import com.example.dynamicdependency.factory.MessageServiceFactory;
import com.example.dynamicdependency.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageServiceFactory messageServiceFactory;

    @Autowired
    public MessageController(MessageServiceFactory messageServiceFactory) {
        this.messageServiceFactory = messageServiceFactory;
    }

    @GetMapping("/{provider}")
    public String sendMessage(@PathVariable String provider,
                              @RequestParam String to,
                              @RequestParam String from,
                              @RequestParam String message) {
        MessageService messageService = messageServiceFactory.getMessageService(provider.toUpperCase());
        if(messageService!=null) {
            System.out.println("Sending message using "+ provider);
            String result = messageService.sendMessage(to, from, message);
            System.out.println(result);
            return result;
        }
        return provider + " is not supported as of now!";
    }
}
