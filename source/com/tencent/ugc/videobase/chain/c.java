package com.tencent.ugc.videobase.chain;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPUImageFilter f50833a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50834b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f50835c;

    private c(TXCGPUImageFilter tXCGPUImageFilter, int i11, float[] fArr) {
        this.f50833a = tXCGPUImageFilter;
        this.f50834b = i11;
        this.f50835c = fArr;
    }

    public static Runnable a(TXCGPUImageFilter tXCGPUImageFilter, int i11, float[] fArr) {
        return new c(tXCGPUImageFilter, i11, fArr);
    }

    public final void run() {
        TXCGPUImageFilter.lambda$setFloatVec2OnDraw$2(this.f50833a, this.f50834b, this.f50835c);
    }
}
