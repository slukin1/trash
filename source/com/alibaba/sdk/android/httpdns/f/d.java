package com.alibaba.sdk.android.httpdns.f;

import com.alibaba.sdk.android.httpdns.b.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final c f14586a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, c> f14587b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final Object f14588c = new Object();

    public c a(String str) {
        if (str == null || str.isEmpty()) {
            return this.f14586a;
        }
        c cVar = this.f14587b.get(str);
        if (cVar == null) {
            synchronized (this.f14588c) {
                cVar = this.f14587b.get(str);
                if (cVar == null) {
                    cVar = new c();
                    this.f14587b.put(str, cVar);
                }
            }
        }
        return cVar;
    }

    public List<a> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f14586a.c());
        if (this.f14587b.size() > 0) {
            synchronized (this.f14588c) {
                for (c c11 : this.f14587b.values()) {
                    arrayList.addAll(c11.c());
                }
            }
        }
        return arrayList;
    }
}
