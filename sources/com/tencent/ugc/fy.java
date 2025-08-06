package com.tencent.ugc;

final /* synthetic */ class fy implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider f50536a;

    private fy(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        this.f50536a = uGCSingleFilePixelFrameProvider;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        return new fy(uGCSingleFilePixelFrameProvider);
    }

    public final void run() {
        this.f50536a.decodeInternal();
    }
}
