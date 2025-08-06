package com.tencent.ugc;

final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50926a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50927b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50928c;

    private z(TXVideoEditer tXVideoEditer, int i11, long j11) {
        this.f50926a = tXVideoEditer;
        this.f50927b = i11;
        this.f50928c = j11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11, long j11) {
        return new z(tXVideoEditer, i11, j11);
    }

    public final void run() {
        TXVideoEditer.lambda$stopEffect$29(this.f50926a, this.f50927b, this.f50928c);
    }
}
