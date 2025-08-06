package com.tencent.ugc.videobase.chain;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPUImageFilter f50830a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50831b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f50832c;

    private b(TXCGPUImageFilter tXCGPUImageFilter, int i11, float[] fArr) {
        this.f50830a = tXCGPUImageFilter;
        this.f50831b = i11;
        this.f50832c = fArr;
    }

    public static Runnable a(TXCGPUImageFilter tXCGPUImageFilter, int i11, float[] fArr) {
        return new b(tXCGPUImageFilter, i11, fArr);
    }

    public final void run() {
        TXCGPUImageFilter.lambda$setFloatVec3OnDraw$1(this.f50830a, this.f50831b, this.f50832c);
    }
}
