package com.example.dynamicdependency.service;

public interface MessageService {

    void sendMessage(String to, String from, String message);
    String getProviderName();
}
