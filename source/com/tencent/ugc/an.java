package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class an implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50152a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoEditer.TXVideoPreviewListener f50153b;

    private an(TXVideoEditer tXVideoEditer, TXVideoEditer.TXVideoPreviewListener tXVideoPreviewListener) {
        this.f50152a = tXVideoEditer;
        this.f50153b = tXVideoPreviewListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditer.TXVideoPreviewListener tXVideoPreviewListener) {
        return new an(tXVideoEditer, tXVideoPreviewListener);
    }

    public final void run() {
        TXVideoEditer.lambda$setTXVideoPreviewListener$42(this.f50152a, this.f50153b);
    }
}
