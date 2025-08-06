package com.tencent.ugc.videobase.chain;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPUImageFilter f50836a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50837b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f50838c;

    private d(TXCGPUImageFilter tXCGPUImageFilter, int i11, float[] fArr) {
        this.f50836a = tXCGPUImageFilter;
        this.f50837b = i11;
        this.f50838c = fArr;
    }

    public static Runnable a(TXCGPUImageFilter tXCGPUImageFilter, int i11, float[] fArr) {
        return new d(tXCGPUImageFilter, i11, fArr);
    }

    public final void run() {
        TXCGPUImageFilter.lambda$setFloatVec4OnDraw$3(this.f50836a, this.f50837b, this.f50838c);
    }
}
