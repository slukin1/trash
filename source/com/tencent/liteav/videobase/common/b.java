package com.tencent.liteav.videobase.common;

public enum b {
    UNKNOWN(-1),
    HDR10(0),
    HLG(1),
    UNSUPPORTED(2);
    
    public final int mValue;

    private b(int i11) {
        this.mValue = i11;
    }

    public static b a(int i11) {
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
}
