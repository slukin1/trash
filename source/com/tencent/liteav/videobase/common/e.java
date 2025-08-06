package com.tencent.liteav.videobase.common;

public enum e {
    UNKNOWN(0),
    BASELINE(1),
    MAIN(2),
    HIGH(3),
    BASELINE_RPS(11),
    MAIN_RPS(12),
    HIGH_RPS(13);
    

    /* renamed from: h  reason: collision with root package name */
    private static final e[] f22168h = null;
    public final int mValue;

    /* access modifiers changed from: public */
    static {
        f22168h = values();
    }

    private e(int i11) {
        this.mValue = i11;
    }

    public static e a(int i11) {
        for (e eVar : f22168h) {
            if (eVar.mValue == i11) {
                return eVar;
            }
        }
        return UNKNOWN;
    }
}
