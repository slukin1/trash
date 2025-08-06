package com.tencent.ugc;

final /* synthetic */ class gl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCThumbnailGenerator f50558a;

    private gl(UGCThumbnailGenerator uGCThumbnailGenerator) {
        this.f50558a = uGCThumbnailGenerator;
    }

    public static Runnable a(UGCThumbnailGenerator uGCThumbnailGenerator) {
        return new gl(uGCThumbnailGenerator);
    }

    public final void run() {
        this.f50558a.getNextThumbnail();
    }
}
