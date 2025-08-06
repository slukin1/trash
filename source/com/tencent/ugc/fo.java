package com.tencent.ugc;

final /* synthetic */ class fo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider f50523a;

    private fo(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        this.f50523a = uGCSingleFilePixelFrameProvider;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        return new fo(uGCSingleFilePixelFrameProvider);
    }

    public final void run() {
        this.f50523a.uninitializeInternal();
    }
}
