package com.tencent.ugc.preprocessor;

final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final GPUPreprocessor f50705a;

    /* renamed from: b  reason: collision with root package name */
    private final String f50706b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f50707c;

    private k(GPUPreprocessor gPUPreprocessor, String str, boolean z11) {
        this.f50705a = gPUPreprocessor;
        this.f50706b = str;
        this.f50707c = z11;
    }

    public static Runnable a(GPUPreprocessor gPUPreprocessor, String str, boolean z11) {
        return new k(gPUPreprocessor, str, z11);
    }

    public final void run() {
        GPUPreprocessor.lambda$setGreenScreenFile$6(this.f50705a, this.f50706b, this.f50707c);
    }
}
