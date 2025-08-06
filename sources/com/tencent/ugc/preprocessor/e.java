package com.tencent.ugc.preprocessor;

import com.tencent.ugc.videobase.chain.GPUInterceptor;

final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final GPUPreprocessor f50686a;

    /* renamed from: b  reason: collision with root package name */
    private final GPUInterceptor f50687b;

    private e(GPUPreprocessor gPUPreprocessor, GPUInterceptor gPUInterceptor) {
        this.f50686a = gPUPreprocessor;
        this.f50687b = gPUInterceptor;
    }

    public static Runnable a(GPUPreprocessor gPUPreprocessor, GPUInterceptor gPUInterceptor) {
        return new e(gPUPreprocessor, gPUInterceptor);
    }

    public final void run() {
        GPUPreprocessor.lambda$setInterceptorBeforeWatermark$0(this.f50686a, this.f50687b);
    }
}
