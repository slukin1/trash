package com.hbg.module.huobi.im.utils;

public enum LiveState {
    REGISTER(1),
    LIVING(2),
    PLAYBACK(3);
    
    private final int value;

    private LiveState(int i11) {
        this.value = i11;
    }

    public final int getValue() {
        return this.value;
    }
}
