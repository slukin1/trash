package com.tencent.ugc;

final /* synthetic */ class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50229a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50230b;

    private bn(TXVideoEditer tXVideoEditer, int i11) {
        this.f50229a = tXVideoEditer;
        this.f50230b = i11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11) {
        return new bn(tXVideoEditer, i11);
    }

    public final void run() {
        this.f50229a.handleProcessComplete(this.f50230b);
    }
}
