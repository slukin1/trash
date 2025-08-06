package com.tencent.wxop.stat;

import android.content.Context;

final class m implements Runnable {
    public final /* synthetic */ f bN = null;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f51084e;

    public m(Context context) {
        this.f51084e = context;
    }

    public final void run() {
        try {
            e.a(this.f51084e, false, this.bN);
        } catch (Throwable th2) {
            e.aV.b(th2);
        }
    }
}
