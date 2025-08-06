package com.tencent.ugc.preprocessor;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final BeautyProcessor f50669a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50670b;

    private a(BeautyProcessor beautyProcessor, float f11) {
        this.f50669a = beautyProcessor;
        this.f50670b = f11;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, float f11) {
        return new a(beautyProcessor, f11);
    }

    public final void run() {
        BeautyProcessor.lambda$setBeautyLevel$0(this.f50669a, this.f50670b);
    }
}
