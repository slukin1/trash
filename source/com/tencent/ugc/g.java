package com.tencent.ugc;

final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50539a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50540b;

    private g(TXVideoEditer tXVideoEditer, boolean z11) {
        this.f50539a = tXVideoEditer;
        this.f50540b = z11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, boolean z11) {
        return new g(tXVideoEditer, z11);
    }

    public final void run() {
        TXVideoEditer.lambda$setBGMLoop$12(this.f50539a, this.f50540b);
    }
}
