package com.tencent.ugc;

import android.graphics.Bitmap;

final /* synthetic */ class bq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50235a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f50236b;

    private bq(TXVideoEditer tXVideoEditer, Bitmap bitmap) {
        this.f50235a = tXVideoEditer;
        this.f50236b = bitmap;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, Bitmap bitmap) {
        return new bq(tXVideoEditer, bitmap);
    }

    public final void run() {
        TXVideoEditer.lambda$setFilter$6(this.f50235a, this.f50236b);
    }
}
