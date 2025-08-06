package com.tencent.ugc;

final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50650a;

    private n(TXVideoEditer tXVideoEditer) {
        this.f50650a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new n(tXVideoEditer);
    }

    public final void run() {
        TXVideoEditer.lambda$new$1(this.f50650a);
    }
}
