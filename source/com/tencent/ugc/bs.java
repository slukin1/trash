package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class bs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final int f50239a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoEditer.TXVideoGenerateListener f50240b;

    private bs(int i11, TXVideoEditer.TXVideoGenerateListener tXVideoGenerateListener) {
        this.f50239a = i11;
        this.f50240b = tXVideoGenerateListener;
    }

    public static Runnable a(int i11, TXVideoEditer.TXVideoGenerateListener tXVideoGenerateListener) {
        return new bs(i11, tXVideoGenerateListener);
    }

    public final void run() {
        TXVideoEditer.lambda$notifyGenerateComplete$70(this.f50239a, this.f50240b);
    }
}
