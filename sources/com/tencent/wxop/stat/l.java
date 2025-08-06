package com.tencent.wxop.stat;

import android.content.Context;

final class l implements Runnable {
    public final /* synthetic */ f bN = null;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f51083e;

    public l(Context context) {
        this.f51083e = context;
    }

    public final void run() {
        Context context = this.f51083e;
        if (context == null) {
            e.aV.error("The Context of StatService.onResume() can not be null!");
        } else {
            e.a(context, com.tencent.wxop.stat.b.l.B(context), this.bN);
        }
    }
}
