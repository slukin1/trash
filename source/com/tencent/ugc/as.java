package com.tencent.ugc;

final /* synthetic */ class as implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50161a;

    private as(TXVideoEditer tXVideoEditer) {
        this.f50161a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new as(tXVideoEditer);
    }

    public final void run() {
        TXVideoEditer.lambda$stopPlay$48(this.f50161a);
    }
}
