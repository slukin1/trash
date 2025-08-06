package com.tencent.ugc;

import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.ugc.TXVideoEditConstants;

final /* synthetic */ class bt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50241a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoEditConstants.TXPreviewParam f50242b;

    /* renamed from: c  reason: collision with root package name */
    private final DisplayTarget f50243c;

    private bt(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXPreviewParam tXPreviewParam, DisplayTarget displayTarget) {
        this.f50241a = tXVideoEditer;
        this.f50242b = tXPreviewParam;
        this.f50243c = displayTarget;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXPreviewParam tXPreviewParam, DisplayTarget displayTarget) {
        return new bt(tXVideoEditer, tXPreviewParam, displayTarget);
    }

    public final void run() {
        TXVideoEditer.lambda$null$43(this.f50241a, this.f50242b, this.f50243c);
    }
}
