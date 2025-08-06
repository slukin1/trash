package com.tencent.ugc;

final /* synthetic */ class ap implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50156a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50157b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50158c;

    private ap(TXVideoEditer tXVideoEditer, long j11, long j12) {
        this.f50156a = tXVideoEditer;
        this.f50157b = j11;
        this.f50158c = j12;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, long j11, long j12) {
        return new ap(tXVideoEditer, j11, j12);
    }

    public final void run() {
        TXVideoEditer.lambda$startPlayFromTime$45(this.f50156a, this.f50157b, this.f50158c);
    }
}
