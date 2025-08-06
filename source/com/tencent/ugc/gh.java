package com.tencent.ugc;

final /* synthetic */ class gh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCThumbnailGenerator f50549a;

    private gh(UGCThumbnailGenerator uGCThumbnailGenerator) {
        this.f50549a = uGCThumbnailGenerator;
    }

    public static Runnable a(UGCThumbnailGenerator uGCThumbnailGenerator) {
        return new gh(uGCThumbnailGenerator);
    }

    public final void run() {
        UGCThumbnailGenerator.lambda$uninitialize$0(this.f50549a);
    }
}
