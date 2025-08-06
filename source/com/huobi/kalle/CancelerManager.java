package com.huobi.kalle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CancelerManager {

    /* renamed from: a  reason: collision with root package name */
    public final Map<k, c> f74663a = new ConcurrentHashMap();

    public void a(k kVar, c cVar) {
        this.f74663a.put(kVar, cVar);
    }

    public void b(k kVar) {
        this.f74663a.remove(kVar);
    }
}
