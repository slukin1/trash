package com.tencent.ugc.beauty.gpufilters;

final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPULookupFilterGroup f50208a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50209b;

    private e(TXCGPULookupFilterGroup tXCGPULookupFilterGroup, float f11) {
        this.f50208a = tXCGPULookupFilterGroup;
        this.f50209b = f11;
    }

    public static Runnable a(TXCGPULookupFilterGroup tXCGPULookupFilterGroup, float f11) {
        return new e(tXCGPULookupFilterGroup, f11);
    }

    public final void run() {
        TXCGPULookupFilterGroup.lambda$setIntensity$1(this.f50208a, this.f50209b);
    }
}
