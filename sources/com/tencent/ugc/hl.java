package com.tencent.ugc;

final /* synthetic */ class hl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCWatermarkAlphaTextureFilter f50617a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50618b;

    private hl(UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter, boolean z11) {
        this.f50617a = uGCWatermarkAlphaTextureFilter;
        this.f50618b = z11;
    }

    public static Runnable a(UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter, boolean z11) {
        return new hl(uGCWatermarkAlphaTextureFilter, z11);
    }

    public final void run() {
        this.f50617a.mIsShowBackImageMoment = this.f50618b;
    }
}
