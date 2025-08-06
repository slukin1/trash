package com.tencent.ugc;

final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50588a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50589b;

    private h(TXVideoEditer tXVideoEditer, long j11) {
        this.f50588a = tXVideoEditer;
        this.f50589b = j11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, long j11) {
        return new h(tXVideoEditer, j11);
    }

    public final void run() {
        TXVideoEditer.lambda$setBGMAtVideoTime$13(this.f50588a, this.f50589b);
    }
}
