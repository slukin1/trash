package com.tencent.ugc;

final /* synthetic */ class fs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider f50527a;

    private fs(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        this.f50527a = uGCSingleFilePixelFrameProvider;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        return new fs(uGCSingleFilePixelFrameProvider);
    }

    public final void run() {
        this.f50527a.stopInternal();
    }
}
