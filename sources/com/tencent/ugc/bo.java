package com.tencent.ugc;

final /* synthetic */ class bo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50231a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50232b;

    private bo(TXVideoEditer tXVideoEditer, int i11) {
        this.f50231a = tXVideoEditer;
        this.f50232b = i11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11) {
        return new bo(tXVideoEditer, i11);
    }

    public final void run() {
        this.f50231a.handleProcessComplete(this.f50232b);
    }
}
