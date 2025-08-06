package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditConstants;

final /* synthetic */ class af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50135a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoEditConstants.TXThumbnail f50136b;

    private af(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXThumbnail tXThumbnail) {
        this.f50135a = tXVideoEditer;
        this.f50136b = tXThumbnail;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXThumbnail tXThumbnail) {
        return new af(tXVideoEditer, tXThumbnail);
    }

    public final void run() {
        TXVideoEditer.lambda$setThumbnail$35(this.f50135a, this.f50136b);
    }
}
