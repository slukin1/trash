package com.tencent.ugc;

final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50820a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50821b;

    private u(TXVideoEditer tXVideoEditer, boolean z11) {
        this.f50820a = tXVideoEditer;
        this.f50821b = z11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, boolean z11) {
        return new u(tXVideoEditer, z11);
    }

    public final void run() {
        TXVideoEditer.lambda$setReverse$25(this.f50820a, this.f50821b);
    }
}
