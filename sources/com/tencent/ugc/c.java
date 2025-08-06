package com.tencent.ugc;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50263a;

    private c(TXVideoEditer tXVideoEditer) {
        this.f50263a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new c(tXVideoEditer);
    }

    public final void run() {
        TXVideoEditer.lambda$new$0(this.f50263a);
    }
}
