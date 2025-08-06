package com.tencent.ugc;

final /* synthetic */ class fw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider f50534a;

    private fw(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        this.f50534a = uGCSingleFilePixelFrameProvider;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider) {
        return new fw(uGCSingleFilePixelFrameProvider);
    }

    public final void run() {
        this.f50534a.onDecodeCompletedInternal();
    }
}
