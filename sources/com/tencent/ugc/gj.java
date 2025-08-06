package com.tencent.ugc;

final /* synthetic */ class gj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCThumbnailGenerator f50552a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50553b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50554c;

    private gj(UGCThumbnailGenerator uGCThumbnailGenerator, long j11, long j12) {
        this.f50552a = uGCThumbnailGenerator;
        this.f50553b = j11;
        this.f50554c = j12;
    }

    public static Runnable a(UGCThumbnailGenerator uGCThumbnailGenerator, long j11, long j12) {
        return new gj(uGCThumbnailGenerator, j11, j12);
    }

    public final void run() {
        this.f50552a.mMediaListSource.setVideoSourceRange(this.f50553b, this.f50554c);
    }
}
