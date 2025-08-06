package com.tencent.ugc;

import com.tencent.ugc.UGCSingleFilePixelFrameProvider;
import com.tencent.ugc.videobase.frame.PixelFrame;

final /* synthetic */ class fz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider.AnonymousClass1 f50537a;

    /* renamed from: b  reason: collision with root package name */
    private final PixelFrame f50538b;

    private fz(UGCSingleFilePixelFrameProvider.AnonymousClass1 r12, PixelFrame pixelFrame) {
        this.f50537a = r12;
        this.f50538b = pixelFrame;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider.AnonymousClass1 r12, PixelFrame pixelFrame) {
        return new fz(r12, pixelFrame);
    }

    public final void run() {
        UGCSingleFilePixelFrameProvider.this.onDecodeFrameInternal(this.f50538b);
    }
}
