package com.tencent.ugc;

import com.tencent.ugc.UGCVideoProcessor;
import com.tencent.ugc.videobase.frame.PixelFrame;

final /* synthetic */ class hh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor.AnonymousClass2 f50609a;

    /* renamed from: b  reason: collision with root package name */
    private final PixelFrame f50610b;

    private hh(UGCVideoProcessor.AnonymousClass2 r12, PixelFrame pixelFrame) {
        this.f50609a = r12;
        this.f50610b = pixelFrame;
    }

    public static Runnable a(UGCVideoProcessor.AnonymousClass2 r12, PixelFrame pixelFrame) {
        return new hh(r12, pixelFrame);
    }

    public final void run() {
        UGCVideoProcessor.AnonymousClass2.a(this.f50609a, this.f50610b);
    }
}
