package com.tencent.wxop.stat;

import android.content.Context;

final class h implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f51078e;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f51079g = -1;

    public h(Context context) {
        this.f51078e = context;
    }

    public final void run() {
        try {
            e.p(this.f51078e);
            t.s(this.f51078e).b(this.f51079g);
        } catch (Throwable th2) {
            e.aV.b(th2);
            e.a(this.f51078e, th2);
        }
    }
}
