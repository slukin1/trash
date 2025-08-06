package com.tencent.ugc;

final /* synthetic */ class gm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCThumbnailGenerator f50559a;

    private gm(UGCThumbnailGenerator uGCThumbnailGenerator) {
        this.f50559a = uGCThumbnailGenerator;
    }

    public static Runnable a(UGCThumbnailGenerator uGCThumbnailGenerator) {
        return new gm(uGCThumbnailGenerator);
    }

    public final void run() {
        UGCThumbnailGenerator.lambda$stop$4(this.f50559a);
    }
}
