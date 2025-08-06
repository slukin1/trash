package com.tencent.ugc;

final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50920a;

    private w(TXVideoEditer tXVideoEditer) {
        this.f50920a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new w(tXVideoEditer);
    }

    public final void run() {
        TXVideoEditer.lambda$deleteLastTransitionEffect$27(this.f50920a);
    }
}
