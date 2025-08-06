package com.tencent.ugc;

final /* synthetic */ class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50139a;

    private ah(TXVideoEditer tXVideoEditer) {
        this.f50139a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new ah(tXVideoEditer);
    }

    public final void run() {
        this.f50139a.processVideoInternal();
    }
}
