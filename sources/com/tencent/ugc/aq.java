package com.tencent.ugc;

final /* synthetic */ class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50159a;

    private aq(TXVideoEditer tXVideoEditer) {
        this.f50159a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new aq(tXVideoEditer);
    }

    public final void run() {
        TXVideoEditer.lambda$pausePlay$46(this.f50159a);
    }
}
