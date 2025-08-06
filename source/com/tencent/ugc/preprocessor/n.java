package com.tencent.ugc.preprocessor;

import android.graphics.Bitmap;

final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f50713a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f50714b;

    /* renamed from: c  reason: collision with root package name */
    private final float f50715c;

    /* renamed from: d  reason: collision with root package name */
    private final float f50716d;

    /* renamed from: e  reason: collision with root package name */
    private final float f50717e;

    private n(VideoPreprocessor videoPreprocessor, Bitmap bitmap, float f11, float f12, float f13) {
        this.f50713a = videoPreprocessor;
        this.f50714b = bitmap;
        this.f50715c = f11;
        this.f50716d = f12;
        this.f50717e = f13;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, Bitmap bitmap, float f11, float f12, float f13) {
        return new n(videoPreprocessor, bitmap, f11, f12, f13);
    }

    public final void run() {
        this.f50713a.mPreprocessor.setWatermark(this.f50714b, this.f50715c, this.f50716d, this.f50717e);
    }
}
