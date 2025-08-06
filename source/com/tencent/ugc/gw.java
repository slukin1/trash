package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class gw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50582a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoEditer.TXVideoCustomProcessListener f50583b;

    private gw(UGCVideoProcessor uGCVideoProcessor, TXVideoEditer.TXVideoCustomProcessListener tXVideoCustomProcessListener) {
        this.f50582a = uGCVideoProcessor;
        this.f50583b = tXVideoCustomProcessListener;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, TXVideoEditer.TXVideoCustomProcessListener tXVideoCustomProcessListener) {
        return new gw(uGCVideoProcessor, tXVideoCustomProcessListener);
    }

    public final void run() {
        this.f50582a.mTXVideoCustomProcessListener = this.f50583b;
    }
}
