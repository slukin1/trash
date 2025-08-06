package com.tencent.android.tpush.service;

import android.os.PowerManager;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f69678a;

    /* renamed from: b  reason: collision with root package name */
    private PowerManager.WakeLock f69679b = null;

    private d() {
    }

    public static d a() {
        if (f69678a == null) {
            f69678a = new d();
        }
        return f69678a;
    }

    public PowerManager.WakeLock b() {
        return this.f69679b;
    }
}
