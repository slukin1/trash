package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class s {

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, l1> f38259b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static s f38260c;

    /* renamed from: a  reason: collision with root package name */
    private g1 f38261a = new g1();

    private s() {
    }

    public static s c() {
        if (f38260c == null) {
            d();
        }
        return f38260c;
    }

    private static synchronized void d() {
        synchronized (s.class) {
            if (f38260c == null) {
                f38260c = new s();
            }
        }
    }

    public l1 a(String str) {
        return f38259b.get(str);
    }

    public Set<String> a() {
        return f38259b.keySet();
    }

    public void a(String str, l1 l1Var) {
        f38259b.put(str, l1Var);
    }

    public g1 b() {
        return this.f38261a;
    }
}
