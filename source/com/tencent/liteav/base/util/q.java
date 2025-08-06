package com.tencent.liteav.base.util;

import com.tencent.liteav.base.util.l;

final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final l.a f21565a;

    private q(l.a aVar) {
        this.f21565a = aVar;
    }

    public static Runnable a(l.a aVar) {
        return new q(aVar);
    }

    public final void run() {
        l.a aVar = this.f21565a;
        l.this.f21550a.execute(aVar.f21554b);
    }
}
