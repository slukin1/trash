package com.tencent.ugc.preprocessor;

final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final GPUPreprocessor f50724a;

    private r(GPUPreprocessor gPUPreprocessor) {
        this.f50724a = gPUPreprocessor;
    }

    public static Runnable a(GPUPreprocessor gPUPreprocessor) {
        return new r(gPUPreprocessor);
    }

    public final void run() {
        this.f50724a.uninitialize();
    }
}
