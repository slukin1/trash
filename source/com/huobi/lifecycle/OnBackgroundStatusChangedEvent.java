package com.huobi.lifecycle;

public class OnBackgroundStatusChangedEvent {

    /* renamed from: a  reason: collision with root package name */
    public STATUS f74937a;

    public enum STATUS {
        BACKGROUND,
        FOREGROUND
    }

    public OnBackgroundStatusChangedEvent(STATUS status) {
        this.f74937a = status;
    }

    public STATUS a() {
        return this.f74937a;
    }
}
