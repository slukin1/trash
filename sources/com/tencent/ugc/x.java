package com.tencent.ugc;

final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50921a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50922b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50923c;

    private x(TXVideoEditer tXVideoEditer, int i11, long j11) {
        this.f50921a = tXVideoEditer;
        this.f50922b = i11;
        this.f50923c = j11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11, long j11) {
        return new x(tXVideoEditer, i11, j11);
    }

    public final void run() {
        TXVideoEditer.lambda$startEffect$28(this.f50921a, this.f50922b, this.f50923c);
    }
}
