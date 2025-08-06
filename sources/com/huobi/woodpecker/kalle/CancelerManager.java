package com.huobi.woodpecker.kalle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CancelerManager {

    /* renamed from: a  reason: collision with root package name */
    public final Map<k, d> f21021a = new ConcurrentHashMap();

    public void a(k kVar, d dVar) {
        this.f21021a.put(kVar, dVar);
    }

    public void b(k kVar) {
        this.f21021a.remove(kVar);
    }
}
