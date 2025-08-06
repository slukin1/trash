package com.tencent.ugc;

final /* synthetic */ class aw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50167a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50168b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50169c;

    private aw(TXVideoEditer tXVideoEditer, long j11, long j12) {
        this.f50167a = tXVideoEditer;
        this.f50168b = j11;
        this.f50169c = j12;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, long j11, long j12) {
        return new aw(tXVideoEditer, j11, j12);
    }

    public final void run() {
        TXVideoEditer.lambda$setCutFromTime$51(this.f50167a, this.f50168b, this.f50169c);
    }
}
