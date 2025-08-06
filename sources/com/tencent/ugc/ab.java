package com.tencent.ugc;

final /* synthetic */ class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50120a;

    private ab(TXVideoEditer tXVideoEditer) {
        this.f50120a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new ab(tXVideoEditer);
    }

    public final void run() {
        TXVideoEditer.lambda$deleteAllEffect$31(this.f50120a);
    }
}
