package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.c;
import com.tencent.wxop.stat.a.f;
import com.tencent.wxop.stat.b.b;

final class ap implements Runnable {

    /* renamed from: dn  reason: collision with root package name */
    public final /* synthetic */ Throwable f50981dn;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f50982e;

    public ap(Context context, Throwable th2) {
        this.f50982e = context;
        this.f50981dn = th2;
    }

    public final void run() {
        try {
            if (c.l()) {
                Context context = this.f50982e;
                new p(new c(context, e.a(context, false, (f) null), this.f50981dn, f.f50951bw)).ah();
            }
        } catch (Throwable th2) {
            b K = e.aV;
            K.d("reportSdkSelfException error: " + th2);
        }
    }
}
