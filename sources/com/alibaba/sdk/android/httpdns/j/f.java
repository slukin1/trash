package com.alibaba.sdk.android.httpdns.j;

import java.util.HashMap;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Long> f14658a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public int f14659b = 300000;

    /* renamed from: c  reason: collision with root package name */
    public Object f14660c = new Object();

    public boolean a(String str) {
        Long l11 = this.f14658a.get(str);
        if (l11 != null) {
            if (System.currentTimeMillis() - l11.longValue() > ((long) this.f14659b)) {
                b(str);
            }
            return false;
        }
        synchronized (this.f14660c) {
            if (this.f14658a.get(str) != null) {
                return false;
            }
            this.f14658a.put(str, Long.valueOf(System.currentTimeMillis()));
            return true;
        }
    }

    public void b(String str) {
        this.f14658a.remove(str);
    }
}
