package com.huochat.community.eventbus;

public class EventMessage<T> {
    private T data;
    private int eventCode = -1;

    public EventMessage(int i11) {
        this.eventCode = i11;
    }

    public T getData() {
        return this.data;
    }

    public int getEventCode() {
        return this.eventCode;
    }

    public EventMessage(int i11, T t11) {
        this.eventCode = i11;
        this.data = t11;
    }
}
