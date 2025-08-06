package com.tencent.thumbplayer.tcmedia.tplayer.a;

import java.util.HashMap;
import java.util.Map;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<Integer, String> f49530a;

    /* renamed from: b  reason: collision with root package name */
    private int f49531b = 1;

    static {
        HashMap hashMap = new HashMap();
        f49530a = hashMap;
        hashMap.put(1, "IDLE");
        hashMap.put(2, "PREPARING");
        hashMap.put(3, "PREPARED");
    }

    public synchronized void a(int i11) {
        this.f49531b = i11;
    }

    public synchronized boolean b(int i11) {
        return this.f49531b == i11;
    }

    public synchronized String toString() {
        return "state[ cur : " + f49530a.get(Integer.valueOf(this.f49531b)) + " ]";
    }
}
