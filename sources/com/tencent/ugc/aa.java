package com.tencent.ugc;

final /* synthetic */ class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50119a;

    private aa(TXVideoEditer tXVideoEditer) {
        this.f50119a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new aa(tXVideoEditer);
    }

    public final void run() {
        TXVideoEditer.lambda$deleteLastEffect$30(this.f50119a);
    }
}
