package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50141a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoEditer.TXVideoCustomProcessListener f50142b;

    private aj(TXVideoEditer tXVideoEditer, TXVideoEditer.TXVideoCustomProcessListener tXVideoCustomProcessListener) {
        this.f50141a = tXVideoEditer;
        this.f50142b = tXVideoCustomProcessListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditer.TXVideoCustomProcessListener tXVideoCustomProcessListener) {
        return new aj(tXVideoEditer, tXVideoCustomProcessListener);
    }

    public final void run() {
        TXVideoEditer.lambda$setCustomVideoProcessListener$3(this.f50141a, this.f50142b);
    }
}
