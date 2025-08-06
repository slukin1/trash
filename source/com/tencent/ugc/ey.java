package com.tencent.ugc;

final /* synthetic */ class ey implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMultiFilePixelFrameProvider f50493a;

    private ey(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider) {
        this.f50493a = uGCMultiFilePixelFrameProvider;
    }

    public static Runnable a(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider) {
        return new ey(uGCMultiFilePixelFrameProvider);
    }

    public final void run() {
        this.f50493a.readFrameToQueue();
    }
}
