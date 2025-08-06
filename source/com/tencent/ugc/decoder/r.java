package com.tencent.ugc.decoder;

import com.tencent.ugc.decoder.UGCVideoDecodeController;
import com.tencent.ugc.videobase.frame.PixelFrame;

final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoDecodeController.a f50355a;

    /* renamed from: b  reason: collision with root package name */
    private final PixelFrame f50356b;

    private r(UGCVideoDecodeController.a aVar, PixelFrame pixelFrame) {
        this.f50355a = aVar;
        this.f50356b = pixelFrame;
    }

    public static Runnable a(UGCVideoDecodeController.a aVar, PixelFrame pixelFrame) {
        return new r(aVar, pixelFrame);
    }

    public final void run() {
        UGCVideoDecodeController.a.a(this.f50355a, this.f50356b);
    }
}
