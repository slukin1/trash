package com.tencent.ugc.preprocessor;

final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f50747a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50748b;

    private z(VideoPreprocessor videoPreprocessor, float f11) {
        this.f50747a = videoPreprocessor;
        this.f50748b = f11;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, float f11) {
        return new z(videoPreprocessor, f11);
    }

    public final void run() {
        this.f50747a.mPreprocessor.setFilterMixLevel(this.f50748b);
    }
}
