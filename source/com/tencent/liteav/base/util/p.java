package com.tencent.liteav.base.util;

import com.tencent.liteav.base.util.l;

final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final l.a f21563a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f21564b;

    private p(l.a aVar, Runnable runnable) {
        this.f21563a = aVar;
        this.f21564b = runnable;
    }

    public static Runnable a(l.a aVar, Runnable runnable) {
        return new p(aVar, runnable);
    }

    public final void run() {
        l.a aVar = this.f21563a;
        this.f21564b.run();
        synchronized (l.this) {
            l.this.f21552c.remove(aVar);
        }
    }
}
