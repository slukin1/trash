package com.tencent.ugc;

final /* synthetic */ class ar implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50160a;

    private ar(TXVideoEditer tXVideoEditer) {
        this.f50160a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new ar(tXVideoEditer);
    }

    public final void run() {
        TXVideoEditer.lambda$resumePlay$47(this.f50160a);
    }
}
