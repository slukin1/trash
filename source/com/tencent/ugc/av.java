package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class av implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50165a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoEditer.TXVideoGenerateListener f50166b;

    private av(TXVideoEditer tXVideoEditer, TXVideoEditer.TXVideoGenerateListener tXVideoGenerateListener) {
        this.f50165a = tXVideoEditer;
        this.f50166b = tXVideoGenerateListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditer.TXVideoGenerateListener tXVideoGenerateListener) {
        return new av(tXVideoEditer, tXVideoGenerateListener);
    }

    public final void run() {
        TXVideoEditer.lambda$setVideoGenerateListener$50(this.f50165a, this.f50166b);
    }
}
