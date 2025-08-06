package com.huobi.app.rms.bean;

public enum HBRMSResourceDownloadMode {
    Async(1),
    Background(2),
    Idle(3),
    Force(4),
    UnNeedLoad(100),
    Ineffective(101);
    
    private final int value;

    private HBRMSResourceDownloadMode(int i11) {
        this.value = i11;
    }

    public final int getValue() {
        return this.value;
    }
}
