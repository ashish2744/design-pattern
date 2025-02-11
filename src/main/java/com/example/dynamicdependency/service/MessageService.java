package com.example.dynamicdependency.service;

public interface MessageService {

    String sendMessage(String to, String from, String message);
    String getProviderName();
}
