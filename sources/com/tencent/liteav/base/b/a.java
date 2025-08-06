package com.tencent.liteav.base.b;

import android.os.SystemClock;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public long f21407a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final long f21408b;

    public a(long j11) {
        this.f21408b = j11;
    }

    public final boolean a() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = this.f21407a;
        if (j11 != 0 && elapsedRealtime - j11 <= this.f21408b) {
            return false;
        }
        this.f21407a = SystemClock.elapsedRealtime();
        return true;
    }
}
