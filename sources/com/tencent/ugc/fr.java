package com.tencent.ugc;

final /* synthetic */ class fr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider f50526a;

    private fr(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        this.f50526a = uGCSingleFilePixelFrameProvider;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        return new fr(uGCSingleFilePixelFrameProvider);
    }

    public final void run() {
        this.f50526a.startInternal();
    }
}
