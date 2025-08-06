package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class bl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50225a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50226b;

    /* renamed from: c  reason: collision with root package name */
    private final TXVideoEditer.TXVideoPreviewListener f50227c;

    private bl(TXVideoEditer tXVideoEditer, int i11, TXVideoEditer.TXVideoPreviewListener tXVideoPreviewListener) {
        this.f50225a = tXVideoEditer;
        this.f50226b = i11;
        this.f50227c = tXVideoPreviewListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11, TXVideoEditer.TXVideoPreviewListener tXVideoPreviewListener) {
        return new bl(tXVideoEditer, i11, tXVideoPreviewListener);
    }

    public final void run() {
        TXVideoEditer.lambda$notifyPreviewProgress$65(this.f50225a, this.f50226b, this.f50227c);
    }
}
