package com.sumsub.sentry.android;

import android.os.Looper;
import com.sumsub.sentry.k0;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f30279a = new f();

    public final boolean a(Thread thread) {
        return a(thread.getId());
    }

    public final boolean a() {
        return a(Thread.currentThread());
    }

    public final boolean a(k0 k0Var) {
        Long g11 = k0Var.g();
        if (g11 == null) {
            return false;
        }
        return f30279a.a(g11.longValue());
    }

    public final boolean a(long j11) {
        return Looper.getMainLooper().getThread().getId() == j11;
    }
}
