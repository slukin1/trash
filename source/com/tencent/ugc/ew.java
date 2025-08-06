package com.tencent.ugc;

final /* synthetic */ class ew implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMultiFilePixelFrameProvider f50489a;

    private ew(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider) {
        this.f50489a = uGCMultiFilePixelFrameProvider;
    }

    public static Runnable a(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider) {
        return new ew(uGCMultiFilePixelFrameProvider);
    }

    public final void run() {
        UGCMultiFilePixelFrameProvider.lambda$stop$1(this.f50489a);
    }
}
