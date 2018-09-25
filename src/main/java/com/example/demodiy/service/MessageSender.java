package com.example.demodiy.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class MessageSender implements IMessageSender {

    @Override
    public void send(String to, String message) {
        System.out.println(message);
    }
}
