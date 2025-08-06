package com.tencent.liteav.base.util;

public enum k {
    NORMAL(0),
    ROTATION_90(90),
    ROTATION_180(180),
    ROTATION_270(270);
    

    /* renamed from: e  reason: collision with root package name */
    private static final k[] f21548e = null;
    public final int mValue;

    /* access modifiers changed from: public */
    static {
        f21548e = values();
    }

    private k(int i11) {
        this.mValue = i11;
    }

    public static k a(int i11) {
        for (k kVar : f21548e) {
            if (kVar.mValue == i11) {
                return kVar;
            }
        }
        return NORMAL;
    }

    public static boolean b(int i11) {
        return i11 == 0 || i11 == 90 || i11 == 180 || i11 == 270;
    }

    public static int a(k kVar) {
        if (kVar != null) {
            return kVar.mValue;
        }
        return NORMAL.mValue;
    }
}
