package com.example.demodiy.model;

public class Mark {
    public enum Subject {
        MATH,
        ART,
        ENGLISH
    }

    public Mark(Subject subject, int mark) {
        this.subject = subject;
        this.mark = mark;
    }

    private Subject subject;
    private int mark;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
