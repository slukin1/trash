package kotlin.time;

import java.text.DecimalFormat;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f56936a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal<DecimalFormat>[] f56937b;

    static {
        Class<b> cls = b.class;
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i11 = 0; i11 < 4; i11++) {
            threadLocalArr[i11] = new ThreadLocal<>();
        }
        f56937b = threadLocalArr;
    }

    public static final boolean a() {
        return f56936a;
    }
}
