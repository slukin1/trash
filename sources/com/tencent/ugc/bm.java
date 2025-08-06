package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class bm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.TXVideoPreviewListener f50228a;

    private bm(TXVideoEditer.TXVideoPreviewListener tXVideoPreviewListener) {
        this.f50228a = tXVideoPreviewListener;
    }

    public static Runnable a(TXVideoEditer.TXVideoPreviewListener tXVideoPreviewListener) {
        return new bm(tXVideoPreviewListener);
    }

    public final void run() {
        this.f50228a.onPreviewFinished();
    }
}
