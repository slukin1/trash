package com.tencent.ugc.preprocessor;

import android.graphics.Bitmap;

final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final GPUPreprocessor f50699a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f50700b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f50701c;

    /* renamed from: d  reason: collision with root package name */
    private final float f50702d;

    /* renamed from: e  reason: collision with root package name */
    private final float f50703e;

    /* renamed from: f  reason: collision with root package name */
    private final float f50704f;

    private j(GPUPreprocessor gPUPreprocessor, Bitmap bitmap, Bitmap bitmap2, float f11, float f12, float f13) {
        this.f50699a = gPUPreprocessor;
        this.f50700b = bitmap;
        this.f50701c = bitmap2;
        this.f50702d = f11;
        this.f50703e = f12;
        this.f50704f = f13;
    }

    public static Runnable a(GPUPreprocessor gPUPreprocessor, Bitmap bitmap, Bitmap bitmap2, float f11, float f12, float f13) {
        return new j(gPUPreprocessor, bitmap, bitmap2, f11, f12, f13);
    }

    public final void run() {
        GPUPreprocessor.lambda$setFilterGroupImages$5(this.f50699a, this.f50700b, this.f50701c, this.f50702d, this.f50703e, this.f50704f);
    }
}
