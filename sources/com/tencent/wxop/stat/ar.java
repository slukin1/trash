package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.a;
import com.tencent.wxop.stat.a.b;

final class ar implements Runnable {
    public final /* synthetic */ f bN = null;

    /* renamed from: do  reason: not valid java name */
    public final /* synthetic */ b f2403do;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f50983e;

    public ar(Context context, b bVar) {
        this.f50983e = context;
        this.f2403do = bVar;
    }

    public final void run() {
        try {
            Context context = this.f50983e;
            a aVar = new a(context, e.a(context, false, this.bN), this.f2403do.f50931a, this.bN);
            aVar.ab().f50933bm = this.f2403do.f50933bm;
            new p(aVar).ah();
        } catch (Throwable th2) {
            e.aV.b(th2);
            e.a(this.f50983e, th2);
        }
    }
}
