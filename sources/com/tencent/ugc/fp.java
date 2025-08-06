package com.tencent.ugc;

final /* synthetic */ class fp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider f50524a;

    private fp(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        this.f50524a = uGCSingleFilePixelFrameProvider;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        return new fp(uGCSingleFilePixelFrameProvider);
    }

    public final void run() {
        this.f50524a.decodeInternal();
    }
}
