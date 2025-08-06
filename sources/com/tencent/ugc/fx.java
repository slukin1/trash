package com.tencent.ugc;

final /* synthetic */ class fx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider f50535a;

    private fx(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        this.f50535a = uGCSingleFilePixelFrameProvider;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        return new fx(uGCSingleFilePixelFrameProvider);
    }

    public final void run() {
        this.f50535a.onDecodeCompletedInternal();
    }
}
