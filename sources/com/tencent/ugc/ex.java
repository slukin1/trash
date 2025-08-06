package com.tencent.ugc;

final /* synthetic */ class ex implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMultiFilePixelFrameProvider f50490a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50491b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f50492c;

    private ex(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider, long j11, boolean z11) {
        this.f50490a = uGCMultiFilePixelFrameProvider;
        this.f50491b = j11;
        this.f50492c = z11;
    }

    public static Runnable a(UGCMultiFilePixelFrameProvider uGCMultiFilePixelFrameProvider, long j11, boolean z11) {
        return new ex(uGCMultiFilePixelFrameProvider, j11, z11);
    }

    public final void run() {
        UGCMultiFilePixelFrameProvider.lambda$seekTo$2(this.f50490a, this.f50491b, this.f50492c);
    }
}
