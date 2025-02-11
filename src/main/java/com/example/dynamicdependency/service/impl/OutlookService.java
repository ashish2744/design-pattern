package com.example.dynamicdependency.service.impl;

import com.example.dynamicdependency.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class OutlookService implements MessageService {

    private final String providerName="OUTLOOK";

    @Override
    public String sendMessage(String to, String from, String message) {
        return String.format("Message sent from [%s] to [%s] with message [%s] using [%s]\n" ,from, to, message, getProviderName());
    }

    @Override
    public String getProviderName() {
        return providerName;
    }
}
