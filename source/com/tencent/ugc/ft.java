package com.tencent.ugc;

final /* synthetic */ class ft implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider f50528a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50529b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f50530c;

    private ft(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider, long j11, boolean z11) {
        this.f50528a = uGCSingleFilePixelFrameProvider;
        this.f50529b = j11;
        this.f50530c = z11;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider, long j11, boolean z11) {
        return new ft(uGCSingleFilePixelFrameProvider, j11, z11);
    }

    public final void run() {
        UGCSingleFilePixelFrameProvider.lambda$seekTo$0(this.f50528a, this.f50529b, this.f50530c);
    }
}
