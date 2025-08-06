package com.tencent.ugc;

final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50640a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50641b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50642c;

    private k(TXVideoEditer tXVideoEditer, long j11, long j12) {
        this.f50640a = tXVideoEditer;
        this.f50641b = j11;
        this.f50642c = j12;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, long j11, long j12) {
        return new k(tXVideoEditer, j11, j12);
    }

    public final void run() {
        TXVideoEditer.lambda$setBGMFadeInOutDuration$16(this.f50640a, this.f50641b, this.f50642c);
    }
}
