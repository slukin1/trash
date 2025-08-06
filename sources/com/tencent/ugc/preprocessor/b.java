package com.tencent.ugc.preprocessor;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final BeautyProcessor f50679a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50680b;

    private b(BeautyProcessor beautyProcessor, float f11) {
        this.f50679a = beautyProcessor;
        this.f50680b = f11;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, float f11) {
        return new b(beautyProcessor, f11);
    }

    public final void run() {
        BeautyProcessor.lambda$setWhitenessLevel$1(this.f50679a, this.f50680b);
    }
}
