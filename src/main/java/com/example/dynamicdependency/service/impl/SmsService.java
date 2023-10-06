package com.example.dynamicdependency.service.impl;

import com.example.dynamicdependency.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class SmsService implements MessageService {

    private final String providerName="SMS";

    @Override
    public void sendMessage(String to, String from, String message) {
        System.out.printf("Message sent from [%s] to [%s] with message [%s]\n" ,from, to, message);
    }

    @Override
    public String getProviderName() {
        return providerName;
    }
}
