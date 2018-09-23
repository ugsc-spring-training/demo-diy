package com.example.demodiy.service;

import com.example.demodiy.model.Mark;

public class ParentService {

    private final String fathersName;
    private final IMessageSender messageSender;

    public ParentService(String fathersName, IMessageSender messageSender) {
        this.fathersName = fathersName;
        this.messageSender = messageSender;
    }

    public void notify(Mark mark) {
        messageSender.send(fathersName, "Dear Mr. " + fathersName + " your kid just got " + mark.getMark());
    }
}
