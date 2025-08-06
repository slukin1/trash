package com.tencent.ugc;

import com.tencent.ugc.UGCVideoProcessor;
import com.tencent.ugc.videobase.frame.PixelFrame;

final /* synthetic */ class hk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor.c f50615a;

    /* renamed from: b  reason: collision with root package name */
    private final PixelFrame f50616b;

    private hk(UGCVideoProcessor.c cVar, PixelFrame pixelFrame) {
        this.f50615a = cVar;
        this.f50616b = pixelFrame;
    }

    public static Runnable a(UGCVideoProcessor.c cVar, PixelFrame pixelFrame) {
        return new hk(cVar, pixelFrame);
    }

    public final void run() {
        UGCVideoProcessor.c.a(this.f50615a, this.f50616b);
    }
}
