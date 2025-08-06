package com.tencent.tpns.baseapi.core.c;

import android.os.PowerManager;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f49878a;

    /* renamed from: b  reason: collision with root package name */
    private PowerManager.WakeLock f49879b = null;

    private c() {
    }

    public static c a() {
        if (f49878a == null) {
            f49878a = new c();
        }
        return f49878a;
    }

    public PowerManager.WakeLock b() {
        return this.f49879b;
    }

    public void a(PowerManager.WakeLock wakeLock) {
        this.f49879b = wakeLock;
    }
}
