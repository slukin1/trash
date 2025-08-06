package com.tencent.wxop.stat;

import android.content.Context;

final class i implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f51080e;

    public i(Context context) {
        this.f51080e = context;
    }

    public final void run() {
        try {
            new Thread(new o(this.f51080e), "NetworkMonitorTask").start();
        } catch (Throwable th2) {
            e.aV.b(th2);
            e.a(this.f51080e, th2);
        }
    }
}
