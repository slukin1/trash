package com.tencent.ugc;

final /* synthetic */ class fq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider f50525a;

    private fq(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        this.f50525a = uGCSingleFilePixelFrameProvider;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        return new fq(uGCSingleFilePixelFrameProvider);
    }

    public final void run() {
        this.f50525a.decodeInternal();
    }
}
