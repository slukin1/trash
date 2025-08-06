package com.adjust.sdk;

public enum TrackingState {
    OPTED_OUT(1);
    
    private int value;

    private TrackingState(int i11) {
        this.value = i11;
    }

    public int getValue() {
        return this.value;
    }
}
