package com.sumsub.sns.internal.fingerprint.tools.threading.safe;

import com.sumsub.sns.internal.log.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f34676a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final long f34677b = 1000;

    /* renamed from: c  reason: collision with root package name */
    public static final long f34678c = 3000;

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal<Boolean> f34679d = new ThreadLocal<>();

    public final void a() {
        f34679d.remove();
    }

    public final boolean b() {
        Boolean bool = f34679d.get();
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final void c() {
        com.sumsub.sns.internal.log.b.b(a.f34862a, "Safe", "logIllegalSafeWithTimeoutUsage", new IllegalStateException("logIllegalSafeWithTimeoutUsage"));
    }

    public final void d() {
        f34679d.set(Boolean.TRUE);
    }
}
