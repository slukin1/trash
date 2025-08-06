package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditConstants;

final /* synthetic */ class cq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50300a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoEditConstants.TXPreviewParam f50301b;

    private cq(TXVideoJoiner tXVideoJoiner, TXVideoEditConstants.TXPreviewParam tXPreviewParam) {
        this.f50300a = tXVideoJoiner;
        this.f50301b = tXPreviewParam;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, TXVideoEditConstants.TXPreviewParam tXPreviewParam) {
        return new cq(tXVideoJoiner, tXPreviewParam);
    }

    public final void run() {
        TXVideoJoiner.lambda$initWithPreview$1(this.f50300a, this.f50301b);
    }
}
