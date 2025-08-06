package com.tencent.ugc.preprocessor;

import android.graphics.Bitmap;

final /* synthetic */ class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f50673a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50674b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f50675c;

    /* renamed from: d  reason: collision with root package name */
    private final float f50676d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f50677e;

    /* renamed from: f  reason: collision with root package name */
    private final float f50678f;

    private ab(VideoPreprocessor videoPreprocessor, float f11, Bitmap bitmap, float f12, Bitmap bitmap2, float f13) {
        this.f50673a = videoPreprocessor;
        this.f50674b = f11;
        this.f50675c = bitmap;
        this.f50676d = f12;
        this.f50677e = bitmap2;
        this.f50678f = f13;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, float f11, Bitmap bitmap, float f12, Bitmap bitmap2, float f13) {
        return new ab(videoPreprocessor, f11, bitmap, f12, bitmap2, f13);
    }

    public final void run() {
        this.f50673a.mPreprocessor.setFilterGroupImages(this.f50674b, this.f50675c, this.f50676d, this.f50677e, this.f50678f);
    }
}
