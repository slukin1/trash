package com.tencent.ugc;

final /* synthetic */ class fu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFilePixelFrameProvider f50531a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50532b;

    private fu(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider, boolean z11) {
        this.f50531a = uGCSingleFilePixelFrameProvider;
        this.f50532b = z11;
    }

    public static Runnable a(UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider, boolean z11) {
        return new fu(uGCSingleFilePixelFrameProvider, z11);
    }

    public final void run() {
        this.f50531a.setReverseInternal(this.f50532b);
    }
}
