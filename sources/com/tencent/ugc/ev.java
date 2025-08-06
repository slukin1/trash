package com.tencent.ugc;

final /* synthetic */ class ev implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMultiFilePixelFrameProvider f50488a;

    private ev(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider) {
        this.f50488a = uGCMultiFilePixelFrameProvider;
    }

    public static Runnable a(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider) {
        return new ev(uGCMultiFilePixelFrameProvider);
    }

    public final void run() {
        UGCMultiFilePixelFrameProvider.lambda$start$0(this.f50488a);
    }
}
