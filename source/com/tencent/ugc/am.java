package com.tencent.ugc;

final /* synthetic */ class am implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50151a;

    private am(TXVideoEditer tXVideoEditer) {
        this.f50151a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new am(tXVideoEditer);
    }

    public final void run() {
        TXVideoEditer.lambda$release$41(this.f50151a);
    }
}
