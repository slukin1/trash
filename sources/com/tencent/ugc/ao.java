package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditConstants;

final /* synthetic */ class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50154a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoEditConstants.TXPreviewParam f50155b;

    private ao(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXPreviewParam tXPreviewParam) {
        this.f50154a = tXVideoEditer;
        this.f50155b = tXPreviewParam;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXPreviewParam tXPreviewParam) {
        return new ao(tXVideoEditer, tXPreviewParam);
    }

    public final void run() {
        TXVideoEditer.lambda$initWithPreview$44(this.f50154a, this.f50155b);
    }
}
