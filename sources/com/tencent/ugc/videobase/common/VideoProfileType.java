package com.tencent.ugc.videobase.common;

public enum VideoProfileType {
    UNKNOWN(0),
    BASELINE(1),
    MAIN(2),
    HIGH(3),
    BASELINE_RPS(11),
    MAIN_RPS(12),
    HIGH_RPS(13);
    
    private static final VideoProfileType[] VALUES = null;
    private final int mValue;

    /* access modifiers changed from: public */
    static {
        VALUES = values();
    }

    private VideoProfileType(int i11) {
        this.mValue = i11;
    }

    public static VideoProfileType fromInteger(int i11) {
        for (VideoProfileType videoProfileType : VALUES) {
            if (videoProfileType.mValue == i11) {
                return videoProfileType;
            }
        }
        return UNKNOWN;
    }

    public final int getValue() {
        return this.mValue;
    }
}
