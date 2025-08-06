package com.tencent.liteav.base.util;

public final class g {
    public static float a(float f11, float f12) {
        if (f11 < f12) {
            return f12;
        }
        if (f11 > 1.0f) {
            return 1.0f;
        }
        return f11;
    }

    public static int a(int i11, int i12, int i13) {
        return i11 < i12 ? i12 : i11 > i13 ? i13 : i11;
    }

    public static long a(long j11, long j12, long j13) {
        return j11 < j12 ? j12 : j11 > j13 ? j13 : j11;
    }
}
