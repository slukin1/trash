package com.tencent.ugc.preprocessor;

final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final GPUPreprocessor f50725a;

    private s(GPUPreprocessor gPUPreprocessor) {
        this.f50725a = gPUPreprocessor;
    }

    public static Runnable a(GPUPreprocessor gPUPreprocessor) {
        return new s(gPUPreprocessor);
    }

    public final void run() {
        this.f50725a.uninitializeGLComponents();
    }
}
