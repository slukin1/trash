package com.qihoo.stat;

import android.content.Context;

public class r extends Thread {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f28837b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f28838c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f28839d;

    public r(boolean z11, long j11, Context context) {
        this.f28837b = z11;
        this.f28838c = j11;
        this.f28839d = context;
    }

    public void run() {
        String o11 = d.f28709a;
        g0.c(o11, "bNormal: " + this.f28837b);
        if (-1 != this.f28838c) {
            d.n(this.f28839d);
        }
    }
}
