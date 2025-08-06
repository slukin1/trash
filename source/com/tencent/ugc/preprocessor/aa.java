package com.tencent.ugc.preprocessor;

import android.graphics.Bitmap;

final /* synthetic */ class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f50671a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f50672b;

    private aa(VideoPreprocessor videoPreprocessor, Bitmap bitmap) {
        this.f50671a = videoPreprocessor;
        this.f50672b = bitmap;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, Bitmap bitmap) {
        return new aa(videoPreprocessor, bitmap);
    }

    public final void run() {
        this.f50671a.mPreprocessor.setFilterGroupImages(1.0f, this.f50672b, this.f50671a.mLookupMixLevel, (Bitmap) null, 0.0f);
    }
}
