package com.example.demodiy.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class RealMessageSender implements IMessageSender {
    @Override
    public void send(String to, String message) {
        System.out.println("really sending the message to " + to);
    }
}
