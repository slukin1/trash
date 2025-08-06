package com.alibaba.sdk.android.httpdns.j;

import java.util.HashMap;
import u2.c;
import w2.a;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f14656a = 300000;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, c> f14657b = new HashMap<>();

    public int[] a(String str) {
        c cVar = this.f14657b.get(a.h(str));
        if (cVar == null || cVar.c() + ((long) this.f14656a) < System.currentTimeMillis()) {
            return null;
        }
        return cVar.a();
    }

    public String[] b(String str) {
        c cVar = this.f14657b.get(a.h(str));
        if (cVar == null || cVar.c() + ((long) this.f14656a) < System.currentTimeMillis()) {
            return null;
        }
        return cVar.b();
    }

    public void c(String str, String[] strArr, int[] iArr) {
        String h11 = a.h(str);
        this.f14657b.put(h11, new c(h11, strArr, iArr));
    }
}
