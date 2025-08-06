package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.l;
import java.lang.Thread;

final class an implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f50979e;

    public an(Context context) {
        this.f50979e = context;
    }

    public final void run() {
        g.r(e.aY).aa();
        l.a(this.f50979e, true);
        t.s(this.f50979e);
        ak.Z(this.f50979e);
        Thread.UncaughtExceptionHandler unused = e.aW = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new n());
        if (c.j() == d.APP_LAUNCH) {
            e.o(this.f50979e);
        }
        if (c.k()) {
            e.aV.e("Init MTA StatService success.");
        }
    }
}
