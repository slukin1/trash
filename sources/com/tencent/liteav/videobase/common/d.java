package com.tencent.liteav.videobase.common;

public enum d {
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
    

    /* renamed from: k  reason: collision with root package name */
    private static final d[] f22159k = null;
    public final int mValue;

    /* access modifiers changed from: public */
    static {
        f22159k = values();
    }

    private d(int i11) {
        this.mValue = i11;
    }

    public static d a(int i11) {
        for (d dVar : f22159k) {
            if (dVar.mValue == i11) {
                return dVar;
            }
        }
        return UNKNOWN;
    }
}
