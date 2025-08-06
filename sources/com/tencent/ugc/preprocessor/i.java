package com.tencent.ugc.preprocessor;

final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final GPUPreprocessor f50697a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50698b;

    private i(GPUPreprocessor gPUPreprocessor, float f11) {
        this.f50697a = gPUPreprocessor;
        this.f50698b = f11;
    }

    public static Runnable a(GPUPreprocessor gPUPreprocessor, float f11) {
        return new i(gPUPreprocessor, f11);
    }

    public final void run() {
        GPUPreprocessor.lambda$setFilterMixLevel$4(this.f50697a, this.f50698b);
    }
}
