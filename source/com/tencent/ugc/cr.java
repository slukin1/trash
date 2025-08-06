package com.tencent.ugc;

import com.tencent.ugc.TXVideoJoiner;

final /* synthetic */ class cr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50302a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoJoiner.TXVideoPreviewListener f50303b;

    private cr(TXVideoJoiner tXVideoJoiner, TXVideoJoiner.TXVideoPreviewListener tXVideoPreviewListener) {
        this.f50302a = tXVideoJoiner;
        this.f50303b = tXVideoPreviewListener;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, TXVideoJoiner.TXVideoPreviewListener tXVideoPreviewListener) {
        return new cr(tXVideoJoiner, tXVideoPreviewListener);
    }

    public final void run() {
        this.f50302a.mTXVideoPreviewListener = this.f50303b;
    }
}
