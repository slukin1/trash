package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50121a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoEditer.TXVideoProcessListener f50122b;

    private ac(TXVideoEditer tXVideoEditer, TXVideoEditer.TXVideoProcessListener tXVideoProcessListener) {
        this.f50121a = tXVideoEditer;
        this.f50122b = tXVideoProcessListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditer.TXVideoProcessListener tXVideoProcessListener) {
        return new ac(tXVideoEditer, tXVideoProcessListener);
    }

    public final void run() {
        TXVideoEditer.lambda$setVideoProcessListener$32(this.f50121a, this.f50122b);
    }
}
