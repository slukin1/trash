package com.tencent.ugc.videobase.common;

public enum HDRType {
    UNKNOWN(-1),
    HDR10(0),
    HLG(1),
    UNSUPPORTED(2);
    
    private final int mValue;

    private HDRType(int i11) {
        this.mValue = i11;
    }

    public static HDRType fromInteger(int i11) {
        if (i11 == 0) {
            return HDR10;
        }
        if (i11 == 1) {
            return HLG;
        }
        if (i11 != 2) {
            return UNKNOWN;
        }
        return UNSUPPORTED;
    }

    public final int getValue() {
        return this.mValue;
    }
}
