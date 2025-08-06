package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;
import com.tencent.ugc.UGCThumbnailGenerator;

final /* synthetic */ class gk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCThumbnailGenerator f50555a;

    /* renamed from: b  reason: collision with root package name */
    private final UGCThumbnailGenerator.UGCThumbnailGenerateParams f50556b;

    /* renamed from: c  reason: collision with root package name */
    private final TXVideoEditer.TXThumbnailListener f50557c;

    private gk(UGCThumbnailGenerator uGCThumbnailGenerator, UGCThumbnailGenerator.UGCThumbnailGenerateParams uGCThumbnailGenerateParams, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        this.f50555a = uGCThumbnailGenerator;
        this.f50556b = uGCThumbnailGenerateParams;
        this.f50557c = tXThumbnailListener;
    }

    public static Runnable a(UGCThumbnailGenerator uGCThumbnailGenerator, UGCThumbnailGenerator.UGCThumbnailGenerateParams uGCThumbnailGenerateParams, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        return new gk(uGCThumbnailGenerator, uGCThumbnailGenerateParams, tXThumbnailListener);
    }

    public final void run() {
        UGCThumbnailGenerator.lambda$start$3(this.f50555a, this.f50556b, this.f50557c);
    }
}
