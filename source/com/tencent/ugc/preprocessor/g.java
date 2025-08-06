package com.tencent.ugc.preprocessor;

import java.util.List;

final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final GPUPreprocessor f50693a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50694b;

    private g(GPUPreprocessor gPUPreprocessor, List list) {
        this.f50693a = gPUPreprocessor;
        this.f50694b = list;
    }

    public static Runnable a(GPUPreprocessor gPUPreprocessor, List list) {
        return new g(gPUPreprocessor, list);
    }

    public final void run() {
        GPUPreprocessor.lambda$setWatermarkList$2(this.f50693a, this.f50694b);
    }
}
