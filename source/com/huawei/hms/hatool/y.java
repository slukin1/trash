package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

public final class y {

    /* renamed from: b  reason: collision with root package name */
    private static y f38295b;

    /* renamed from: a  reason: collision with root package name */
    private volatile Map<String, p0> f38296a = new HashMap();

    private y() {
    }

    private p0 a(String str) {
        if (!this.f38296a.containsKey(str)) {
            this.f38296a.put(str, new p0());
        }
        return this.f38296a.get(str);
    }

    public static y a() {
        if (f38295b == null) {
            b();
        }
        return f38295b;
    }

    private static synchronized void b() {
        synchronized (y.class) {
            if (f38295b == null) {
                f38295b = new y();
            }
        }
    }

    public p0 a(String str, long j11) {
        p0 a11 = a(str);
        a11.a(j11);
        return a11;
    }
}
