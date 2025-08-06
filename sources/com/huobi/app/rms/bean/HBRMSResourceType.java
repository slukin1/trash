package com.huobi.app.rms.bean;

public enum HBRMSResourceType {
    Unknown(0),
    Skin(1),
    EdgeEngine(2),
    H5(3),
    LanguageAndColor(4);
    
    private final int value;

    private HBRMSResourceType(int i11) {
        this.value = i11;
    }

    public final int getValue() {
        return this.value;
    }
}
