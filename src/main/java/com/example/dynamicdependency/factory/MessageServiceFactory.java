package com.example.dynamicdependency.factory;

import com.example.dynamicdependency.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MessageServiceFactory {

    private final Map<String, MessageService> messageServices;

    @Autowired
    public MessageServiceFactory(List<MessageService> messageServiceList) {
        this.messageServices = messageServiceList.stream()
                .collect(Collectors.toMap(MessageService::getProviderName, Function.identity()));
    }

    public MessageService getMessageService(String providerName) {
        return messageServices.get(providerName);
    }
}
