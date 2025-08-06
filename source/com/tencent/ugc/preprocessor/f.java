package com.tencent.ugc.preprocessor;

import android.graphics.Bitmap;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final GPUPreprocessor f50688a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f50689b;

    /* renamed from: c  reason: collision with root package name */
    private final float f50690c;

    /* renamed from: d  reason: collision with root package name */
    private final float f50691d;

    /* renamed from: e  reason: collision with root package name */
    private final float f50692e;

    private f(GPUPreprocessor gPUPreprocessor, Bitmap bitmap, float f11, float f12, float f13) {
        this.f50688a = gPUPreprocessor;
        this.f50689b = bitmap;
        this.f50690c = f11;
        this.f50691d = f12;
        this.f50692e = f13;
    }

    public static Runnable a(GPUPreprocessor gPUPreprocessor, Bitmap bitmap, float f11, float f12, float f13) {
        return new f(gPUPreprocessor, bitmap, f11, f12, f13);
    }

    public final void run() {
        GPUPreprocessor.lambda$setWatermark$1(this.f50688a, this.f50689b, this.f50690c, this.f50691d, this.f50692e);
    }
}
