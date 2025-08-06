package com.tencent.ugc.videobase.common;

public enum CodecType {
    UNKNOWN(-1),
    H264(0),
    H265(1),
    VP8(2),
    KAV1(3);
    
    private static final CodecType[] VALUES = null;
    private final int mValue;

    /* access modifiers changed from: public */
    static {
        VALUES = values();
    }

    private CodecType(int i11) {
        this.mValue = i11;
    }

    public static CodecType fromInteger(int i11) {
        for (CodecType codecType : VALUES) {
            if (i11 == codecType.getValue()) {
                return codecType;
            }
        }
        return H264;
    }

    public final int getValue() {
        return this.mValue;
    }
}
