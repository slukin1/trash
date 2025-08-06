package com.tencent.ugc;

final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50635a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50636b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50637c;

    private i(TXVideoEditer tXVideoEditer, long j11, long j12) {
        this.f50635a = tXVideoEditer;
        this.f50636b = j11;
        this.f50637c = j12;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, long j11, long j12) {
        return new i(tXVideoEditer, j11, j12);
    }

    public final void run() {
        TXVideoEditer.lambda$setBGMStartTime$14(this.f50635a, this.f50636b, this.f50637c);
    }
}
