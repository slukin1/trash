package com.xiaomi.push;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final int f51761a = a(1, 3);

    /* renamed from: b  reason: collision with root package name */
    public static final int f51762b = a(1, 4);

    /* renamed from: c  reason: collision with root package name */
    public static final int f51763c = a(2, 0);

    /* renamed from: d  reason: collision with root package name */
    public static final int f51764d = a(3, 2);

    public static int a(int i11) {
        return i11 & 7;
    }

    public static int a(int i11, int i12) {
        return (i11 << 3) | i12;
    }

    public static int b(int i11) {
        return i11 >>> 3;
    }
}
