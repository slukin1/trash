package com.tencent.ugc.preprocessor;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final BeautyProcessor f50684a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50685b;

    private d(BeautyProcessor beautyProcessor, boolean z11) {
        this.f50684a = beautyProcessor;
        this.f50685b = z11;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, boolean z11) {
        return new d(beautyProcessor, z11);
    }

    public final void run() {
        BeautyProcessor.lambda$setPerformanceMode$3(this.f50684a, this.f50685b);
    }
}
