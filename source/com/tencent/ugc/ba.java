package com.tencent.ugc;

final /* synthetic */ class ba implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50178a;

    private ba(TXVideoEditer tXVideoEditer) {
        this.f50178a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new ba(tXVideoEditer);
    }

    public final void run() {
        TXVideoEditer.lambda$cancel$55(this.f50178a);
    }
}
