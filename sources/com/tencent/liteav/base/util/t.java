package com.tencent.liteav.base.util;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f21571a;

    /* renamed from: b  reason: collision with root package name */
    private static final a<CpuUsageMeasurer> f21572b = new a<>(u.b());

    public static int[] a() {
        if (f21571a) {
            f21571a = false;
            f21572b.a();
            CpuUsageMeasurer.a();
            return new int[]{0, 0};
        }
        f21572b.a();
        return CpuUsageMeasurer.a();
    }
}
