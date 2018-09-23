package com.example.demodiy.service;

public class RealMessageSender implements IMessageSender {
    @Override
    public void send(String to, String message) {
        System.out.println("really sending the message to " + to);
    }
}
