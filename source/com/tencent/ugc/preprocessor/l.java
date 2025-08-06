package com.tencent.ugc.preprocessor;

import com.tencent.ugc.videobase.base.GLConstants;

final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final GPUPreprocessor f50708a;

    /* renamed from: b  reason: collision with root package name */
    private final GLConstants.GLScaleType f50709b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f50710c;

    private l(GPUPreprocessor gPUPreprocessor, GLConstants.GLScaleType gLScaleType, boolean z11) {
        this.f50708a = gPUPreprocessor;
        this.f50709b = gLScaleType;
        this.f50710c = z11;
    }

    public static Runnable a(GPUPreprocessor gPUPreprocessor, GLConstants.GLScaleType gLScaleType, boolean z11) {
        return new l(gPUPreprocessor, gLScaleType, z11);
    }

    public final void run() {
        GPUPreprocessor.lambda$setGreenScreenParam$7(this.f50708a, this.f50709b, this.f50710c);
    }
}
