package com.tencent.ugc.videobase.common;

public enum VideoFrameType {
    UNKNOWN(65535),
    IDR(0),
    P(1),
    B(6),
    P_MULTI_REF(7),
    I(8),
    SEI(17),
    SPS(18),
    PPS(19),
    VPS(20);
    
    private static final VideoFrameType[] VALUES = null;
    private final int mValue;

    /* access modifiers changed from: public */
    static {
        VALUES = values();
    }

    private VideoFrameType(int i11) {
        this.mValue = i11;
    }

    public static VideoFrameType fromInteger(int i11) {
        for (VideoFrameType videoFrameType : VALUES) {
            if (videoFrameType.mValue == i11) {
                return videoFrameType;
            }
        }
        return UNKNOWN;
    }

    public final int getValue() {
        return this.mValue;
    }

    public final boolean isIDRFrame() {
        return this == IDR;
    }
}
