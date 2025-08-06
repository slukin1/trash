package com.tencent.ugc.preprocessor;

final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f50720a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50721b;

    private p(VideoPreprocessor videoPreprocessor, float f11) {
        this.f50720a = videoPreprocessor;
        this.f50721b = f11;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, float f11) {
        return new p(videoPreprocessor, f11);
    }

    public final void run() {
        this.f50720a.mPreprocessor.setGaussianBlurLevel(this.f50721b / 4.0f);
    }
}
