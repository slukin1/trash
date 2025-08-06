package com.tencent.ugc;

final /* synthetic */ class bj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50220a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50221b;

    private bj(TXVideoEditer tXVideoEditer, float f11) {
        this.f50220a = tXVideoEditer;
        this.f50221b = f11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, float f11) {
        return new bj(tXVideoEditer, f11);
    }

    public final void run() {
        TXVideoEditer.lambda$setVideoVolume$63(this.f50220a, this.f50221b);
    }
}
