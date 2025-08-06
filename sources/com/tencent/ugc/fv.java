package com.tencent.ugc;

final /* synthetic */ class fv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider f50533a;

    private fv(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        this.f50533a = uGCSingleFilePixelFrameProvider;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        return new fv(uGCSingleFilePixelFrameProvider);
    }

    public final void run() {
        this.f50533a.decodeInternal();
    }
}
