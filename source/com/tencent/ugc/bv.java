package com.tencent.ugc;

import android.graphics.Bitmap;

final /* synthetic */ class bv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50250a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50251b;

    /* renamed from: c  reason: collision with root package name */
    private final float f50252c;

    /* renamed from: d  reason: collision with root package name */
    private final float f50253d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f50254e;

    /* renamed from: f  reason: collision with root package name */
    private final Bitmap f50255f;

    private bv(TXVideoEditer tXVideoEditer, float f11, float f12, float f13, Bitmap bitmap, Bitmap bitmap2) {
        this.f50250a = tXVideoEditer;
        this.f50251b = f11;
        this.f50252c = f12;
        this.f50253d = f13;
        this.f50254e = bitmap;
        this.f50255f = bitmap2;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, float f11, float f12, float f13, Bitmap bitmap, Bitmap bitmap2) {
        return new bv(tXVideoEditer, f11, f12, f13, bitmap, bitmap2);
    }

    public final void run() {
        TXVideoEditer.lambda$setFilter$7(this.f50250a, this.f50251b, this.f50252c, this.f50253d, this.f50254e, this.f50255f);
    }
}
