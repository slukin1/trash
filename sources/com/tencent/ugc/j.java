package com.tencent.ugc;

final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50638a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50639b;

    private j(TXVideoEditer tXVideoEditer, float f11) {
        this.f50638a = tXVideoEditer;
        this.f50639b = f11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, float f11) {
        return new j(tXVideoEditer, f11);
    }

    public final void run() {
        TXVideoEditer.lambda$setBGMVolume$15(this.f50638a, this.f50639b);
    }
}
