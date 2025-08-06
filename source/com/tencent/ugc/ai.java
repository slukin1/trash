package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.TXVideoProcessListener f50140a;

    private ai(TXVideoEditer.TXVideoProcessListener tXVideoProcessListener) {
        this.f50140a = tXVideoProcessListener;
    }

    public static Runnable a(TXVideoEditer.TXVideoProcessListener tXVideoProcessListener) {
        return new ai(tXVideoProcessListener);
    }

    public final void run() {
        TXVideoEditer.lambda$processVideoInternal$37(this.f50140a);
    }
}
