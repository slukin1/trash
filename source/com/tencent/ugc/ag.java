package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50137a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoEditer.TXThumbnailListener f50138b;

    private ag(TXVideoEditer tXVideoEditer, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        this.f50137a = tXVideoEditer;
        this.f50138b = tXThumbnailListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        return new ag(tXVideoEditer, tXThumbnailListener);
    }

    public final void run() {
        TXVideoEditer.lambda$setThumbnailListener$36(this.f50137a, this.f50138b);
    }
}
