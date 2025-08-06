package com.amazonaws;

import java.util.concurrent.atomic.AtomicLong;

public class SDKGlobalConfiguration {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicLong f14811a = new AtomicLong(0);

    public static long a() {
        return f14811a.get();
    }

    public static void b(long j11) {
        f14811a.set(j11);
    }
}
