package com.tencent.ugc;

final /* synthetic */ class bb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50179a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50180b;

    private bb(TXVideoEditer tXVideoEditer, boolean z11) {
        this.f50179a = tXVideoEditer;
        this.f50180b = z11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, boolean z11) {
        return new bb(tXVideoEditer, z11);
    }

    public final void run() {
        TXVideoEditer.lambda$setIsSplitScreen$56(this.f50179a, this.f50180b);
    }
}
