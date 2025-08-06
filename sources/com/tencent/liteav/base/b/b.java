package com.tencent.liteav.base.b;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final long f21409a = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, a> f21410b = new HashMap();

    public final synchronized a a(String str) {
        a aVar;
        aVar = this.f21410b.get(str);
        if (aVar == null) {
            aVar = new a(f21409a);
            this.f21410b.put(str, aVar);
        }
        return aVar;
    }
}
