package com.tencent.ugc.preprocessor;

final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f50722a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50723b;

    private q(VideoPreprocessor videoPreprocessor, int i11) {
        this.f50722a = videoPreprocessor;
        this.f50723b = i11;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, int i11) {
        return new q(videoPreprocessor, i11);
    }

    public final void run() {
        this.f50722a.mPreprocessor.updateHomeOrientation(this.f50723b);
    }
}
