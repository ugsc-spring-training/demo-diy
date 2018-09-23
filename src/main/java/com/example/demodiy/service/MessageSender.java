package com.example.demodiy.service;

public class MessageSender implements IMessageSender {

    @Override
    public void send(String to, String message) {
        System.out.println(message);
    }
}
