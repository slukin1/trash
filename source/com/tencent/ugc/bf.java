package com.tencent.ugc;

final /* synthetic */ class bf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50213a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50214b;

    private bf(TXVideoEditer tXVideoEditer, float f11) {
        this.f50213a = tXVideoEditer;
        this.f50214b = f11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, float f11) {
        return new bf(tXVideoEditer, f11);
    }

    public final void run() {
        TXVideoEditer.lambda$setSpecialRatio$5(this.f50213a, this.f50214b);
    }
}
