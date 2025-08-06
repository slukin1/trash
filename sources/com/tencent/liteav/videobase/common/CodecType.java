package com.tencent.liteav.videobase.common;

public enum CodecType {
    UNKNOWN(-1),
    H264(0),
    H265(1),
    VP8(2),
    KAV1(3);
    

    /* renamed from: f  reason: collision with root package name */
    private static final CodecType[] f22137f = null;
    public final int mValue;

    /* access modifiers changed from: public */
    static {
        f22137f = values();
    }

    private CodecType(int i11) {
        this.mValue = i11;
    }

    public static CodecType a(int i11) {
        for (CodecType codecType : f22137f) {
            if (i11 == codecType.mValue) {
                return codecType;
            }
        }
        return H264;
    }
}
