package com.tencent.ugc.preprocessor;

final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final GPUPreprocessor f50695a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50696b;

    private h(GPUPreprocessor gPUPreprocessor, float f11) {
        this.f50695a = gPUPreprocessor;
        this.f50696b = f11;
    }

    public static Runnable a(GPUPreprocessor gPUPreprocessor, float f11) {
        return new h(gPUPreprocessor, f11);
    }

    public final void run() {
        GPUPreprocessor.lambda$setGaussianBlurLevel$3(this.f50695a, this.f50696b);
    }
}
